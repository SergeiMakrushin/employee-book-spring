package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeService employeeService;

    private Employee employee;
    private EmployeeRequest employee1;
    private EmployeeRequest employee2;
    private EmployeeRequest employee3;
    private EmployeeRequest employee4;

    @BeforeEach
    public void setUp() {

        employeeService = new EmployeeService();
        employee1 = new EmployeeRequest("Антон", "Иванов", 1, 100);
        employee2 = new EmployeeRequest("Иван", "Петров", 1, 200);
        employee3 = new EmployeeRequest("Ольга", "Ларионова", 2, 120);
        employee4 = new EmployeeRequest("Надежда", "Ильина", 2, 200);

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);
        employeeService.addEmployee(employee4);
    }
//        employee1 = new EmployeeRequest();
//        employeeRequest.setFirstName("Антон");
//        employeeRequest.setLastName("Иванов");
//        employeeRequest.setDepartament(1);
//        employeeRequest.setSalary(100);
//
//        employee2 = new EmployeeRequest();
//        employeeRequest.setFirstName("Иван");
//        employeeRequest.setLastName("Петров");
//        employeeRequest.setDepartament(1);
//        employeeRequest.setSalary(200);
//
//        employee3 = new EmployeeRequest();
//        employeeRequest.setFirstName("Ольга");
//        employeeRequest.setLastName("Ларионова");
//        employeeRequest.setDepartament(2);
//        employeeRequest.setSalary(120);
//
//        employee4 = new EmployeeRequest();
//        employeeRequest.setFirstName("Надежда");
//        employeeRequest.setLastName("Ильина");
//        employeeRequest.setDepartament(2);
//        employeeRequest.setSalary(200);
//
//        employeeService = new EmployeeService();
//        employeeService.addEmployee(employee1);
//        employeeService.addEmployee(employee2);
//        employeeService.addEmployee(employee3);
//        employeeService.addEmployee(employee4);
//    }

    @Test
    void getAllEmployees() {
        int expected = employeeService.getAllEmployees().size();
        int actual = 4;
        assertEquals(expected, actual);
    }

    @Test
    void addEmployee() {

        Collection<Employee> expected = employeeService.getAllEmployees();
        Employee actual = employeeService.getAllEmployees().iterator().next();

        assertNotNull(expected);
        assertInstanceOf(Employee.class, actual);

    }

    @Test
    void getAllEmployeesGroupingDepartment() {
        HashMap<Integer, List<Employee>> employeesMap = new HashMap<>();
        employeesMap.putAll(employeeService.getAllEmployeesGroupingDepartment());
        boolean expected = true;


        for (Map.Entry<Integer, List<Employee>> entry : employeesMap.entrySet()) {
            Integer key = entry.getKey();
            List<Employee> value = entry.getValue();
            for (Employee employee : value) {
                if (employee.getDepartament() == key) {
                    expected = true;
                } else {
                    expected = false;
                }
            }
        }

        assertTrue(expected);
    }

    //
    @Test
    void getDepartmentEmployees() {

        Collection<Integer> expected = employeeService.getDepartmentEmployees(2)
                .stream()
                .map(e -> e.getDepartament())
                .toList();

        Collection<Employee> newEmployeesDepartment = new ArrayList<>();
        Employee employeeOne = new Employee("Ольга", "Ларионова", 2, 120);
        Employee employeeTwo = new Employee("Надежда", "Ильина", 2, 200);
        newEmployeesDepartment.add(employeeOne);
        newEmployeesDepartment.add(employeeTwo);

        Collection<Integer> actual = newEmployeesDepartment
                .stream()
                .map(e -> e.getDepartament())
                .toList();
        assertEquals(expected, actual);
    }

    @Test
    void getSalaryMinDepartment() {

        int actual = employeeService.getSalaryMinDepartment(2).get().getSalary();
        int expected = 120;
        assertEquals(expected, actual);


    }

    @Test
    void getSalaryMaxDepartment() {
        int actual = employeeService.getSalaryMaxDepartment(2).get().getSalary();
        int expected = 200;
        assertEquals(expected, actual);

    }

    @Test
    void getSalarySum() {
        int actual = employeeService.getSalarySum();
        int expected = 100 + 200 + 120 + 200;
        assertEquals(expected, actual);

    }

    @Test
    void getSalaryMin() {
        int actual = employeeService.getSalaryMin().getAsInt();
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void getSalaryMax() {
        int actual = employeeService.getSalaryMax().getAsInt();
        int expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void getHigherMediumSalary() {
        List<Integer> actual = employeeService.getHigherMediumSalary().stream().map(e -> e.getSalary()).toList();
        List<Integer> expected = Arrays.asList(200, 200);
        assertIterableEquals(expected, actual);
    }
}