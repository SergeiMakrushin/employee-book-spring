package com.skypro.employee.service;

import com.skypro.employee.model.Employee;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

   private final EmployeeService employeeService;

    DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    возвращает список сотрудников по департаменту.
    public Collection<Employee> getListEmployeeTheDepartment(int id) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartament() == id)
                .toList();
    }
    //  возвращает сумму зарплат по департаменту.
    public int getSumSalaryTheDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();

    }
    //   возвращает максимальную зарплату по департаменту.
    public OptionalInt getSalaryMaxTheDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .max();
    }

//    возвращает минимальную зарплату по департаменту
    public OptionalInt getSalaryMinTheDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .min();
    }

//    возвращает сотрудников, сгруппированых по отделам
    public Map<Integer, List<Employee>> getAllEmployeesGroupingDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartament));

    }

}
//