package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees_department")
    public Collection<Employee> getDepartmentEmployees(@RequestParam("departmentId") int departmentId) {
        return this.employeeService.getDepartmentEmployees(departmentId);
    }

    @GetMapping("/employees_grouping_department")
    public Map<Integer, List<Employee>> getAllEmployeesGroupingDepartment() {
        return this.employeeService.getAllEmployeesGroupingDepartment();
    }

    @GetMapping("/employees/high-salary")
    public Collection<Employee> getHigherMediumSalary() {
        return this.employeeService.getHigherMediumSalary();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")

    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employees/salary/min")

    public OptionalInt getSalaryMin() {
        return this.employeeService.getSalaryMin();
    }

    @GetMapping("/employees/salary/max")
    public OptionalInt getSalaryMax() {
        return this.employeeService.getSalaryMax();
    }

    @GetMapping("employees/salary/max_department")
    public Optional<Employee> getSalaryMaxDepartment(@RequestParam("departmentId") int departmentId) {
        return this.employeeService.getSalaryMaxDepartment(departmentId);
    }

    @GetMapping("/employees/salary/min_department")
    public Optional<Employee> getSalaryMinDepartment(@RequestParam("departmentId") int departmentId) {
        return this.employeeService.getSalaryMinDepartment(departmentId);
    }


}
