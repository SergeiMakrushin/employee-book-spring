package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    // возвращает список сотрудников по департаменту.
    @GetMapping("{id}/employees/")
    public Collection<Employee> getListEmployeeTheDepartment(@PathVariable("id") int id) {
        return departmentService.getListEmployeeTheDepartment(id);
    }


    //  возвращает сумму зарплат по департаменту.
    @GetMapping("{id}/salary/sum/")
    public int getSumSalaryTheDepartment(@PathVariable("id") int id) {
        return departmentService.getSumSalaryTheDepartment(id);
    }


    //   возвращает максимальную зарплату по департаменту.
    @GetMapping("{id}/salary/max/")
    public OptionalInt getSalaryMaxDepartment(@PathVariable("id") int id) {
        return departmentService.getSalaryMaxTheDepartment(id);
    }


    //   возвращает минимальную зарплату по департаменту.
    @GetMapping("{id}/salary/min/")
    public OptionalInt getSalaryMinDepartment(@PathVariable("id") int id) {
        return departmentService.getSalaryMinTheDepartment(id);
    }


    //    возвращает сотрудников, сгруппированых по отделам
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupingDepartment() {
        return departmentService.getAllEmployeesGroupingDepartment();
    }

}
