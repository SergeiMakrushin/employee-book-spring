package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public Collection<Employee> getAllEmployeesSorted() {
        final List<Employee> employee = employees.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartament))
                .toList();
        return employee;
    }


    public Collection<Employee> getDepartmentEmployees(int departmentId) {
        return employees.values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .toList();
    }

    public Optional<Employee> getSalaryMinDepartment(int departmentId) {
        return employees.values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .min(Comparator.comparing(Employee::getSalary));

    }

    public Optional<Employee> getSalaryMaxDepartment(int departmentId) {

        return employees.values().stream()
                .filter(e -> e.getDepartament() == departmentId)
                .max(Comparator.comparing(Employee::getSalary));

    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }


    public int getSalaryMin() {
        int min = 10000000;
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

        int sum = 0;
        int medium;
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
