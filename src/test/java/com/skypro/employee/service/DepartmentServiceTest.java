package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    Employee employee1 = new Employee("Антон", "Иванов", 1, 100);
    Employee employee2 = new Employee("Иван", "Петров", 1, 210);
    Employee employee3 = new Employee("Ольга", "Ларионова", 2, 120);
    Employee employee4 = new Employee("Надежда", "Ильина", 2, 200);
    Collection<Employee> employeeList = new ArrayList<>();

    @Mock
    private EmployeeService employeeService;
    private DepartmentService departmentService;


    @BeforeEach
    public void setUp() {
        this.employeeService = Mockito.mock(EmployeeService.class);
        this.departmentService = new DepartmentService(employeeService);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

    }

    @Test
    void getListEmployeeTheDepartment() {

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
        Collection<Integer> actual = departmentService.getListEmployeeTheDepartment(2)
                .stream()
                .map(e -> e.getDepartament())
                .toList();

        List<Integer> expected = Arrays.asList(2, 2);
        assertEquals(expected, actual);


    }


    @Test
    void getSumSalaryTheDepartment() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
        int actual = departmentService.getSumSalaryTheDepartment(1);
        int expected = 210 + 100;

        assertEquals(expected, actual);
    }

    @Test
    void getSalaryMaxTheDepartment() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
        int actual = departmentService.getSalaryMaxTheDepartment(2).getAsInt();
        int expected = 200;
        assertEquals(expected, actual);
    }

    @Test
    void getSalaryMinTheDepartment() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
        int actual = departmentService.getSalaryMinTheDepartment(2).getAsInt();
        int expected = 120;
        assertEquals(expected, actual);
    }

    @Test
    void getAllEmployeesGroupingDepartment() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
        HashMap<Integer, List<Employee>> employeesMap = new HashMap<>();
        employeesMap.putAll(departmentService.getAllEmployeesGroupingDepartment());
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
}