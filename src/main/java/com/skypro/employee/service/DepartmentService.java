package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.repozitory.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {

    EmployeeRepository employeeRepository;

    DepartmentService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    public Collection<Employee> getAllEmployees() {
//
//        return employeeRepository.getAllEmployees();
//    }

    // Создать сотрудника

    //    public Employee addEmployee(EmployeeRequest employeeRequest) {
//        return employeeRepository.addEmployee(employeeRequest);
//    }
////DepartmentService()
    //            — возвращает список сотрудников по департаменту.
    public Collection<Employee> getListEmployeeTheDepartment(int departmentId) {
        HashMap<Integer, Employee> emp1 = new HashMap<>(employeeRepository.getAllEmployees());
        return emp1.values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .toList();
    }
    //            — возвращает сумму зарплат по департаменту.
    public int getSumSularyTheDepartment(int departmentId) {
        return employeeRepository.getAllEmployees().values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();

    }
    //            — возвращает максимальную зарплату по департаменту.
    public OptionalInt getSalaryMaxTheDepartment(int departmentId) {
        return employeeRepository.getAllEmployees().values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .max();
    }

//    возвращает минимальную зарплату по департаменту
    public OptionalInt getSalaryMinTheDepartment(int departmentId) {
        return employeeRepository.getAllEmployees().values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .mapToInt(Employee::getSalary)
                .min();
    }

}
//