package com.skypro.employee.repozitory;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class EmployeeRepository {

    HashMap<Integer, Employee> emp=new HashMap<>();

    public HashMap<Integer,Employee> getAllEmployees() {
        return  emp;
//        return this.emp.values();
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

        this.emp.put(employee.getId(), employee);
        return employee;
    }

}
