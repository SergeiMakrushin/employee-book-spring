package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Employee> employees1 = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }


    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }
        Employee employee = new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartament(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getSalaryMin() {
        Integer min = 10000000;
        for (Employee value : employees.values()) {
            if (value.getSalary() < min) {
                min = value.getSalary();
            }
        }
        return min;
    }

    public int getSalaryMax() {
        Integer max = -1;
        for (Employee value : employees.values()) {
            if (value.getSalary() > max) {
                max = value.getSalary();
            }
        }
        return max;
    }

    public Collection<Employee> getHigherMediumSalary() {

        Integer sum = 0;
        Integer medium;
        for (Employee value : employees.values()) {
            sum += value.getSalary();
        }
        medium = sum / employees.size();

        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            Integer key = entry.getKey();
            Employee value = entry.getValue();

            if (value.getSalary() > medium) {
                employees1.put(key, value);

            }
        }
        return this.employees1.values();

    }


}
