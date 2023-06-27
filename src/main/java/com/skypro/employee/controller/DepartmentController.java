package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.OptionalInt;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //    GET http://localhost:8080/department/{id}/employees
//            — возвращает список сотрудников по департаменту.
    @GetMapping("/department/{id}/employees")
    public Collection<Employee> getListEmployeeTheDepartment(@PathParam("id") int id) {
        return departmentService.getListEmployeeTheDepartment(id);
    }

    //    GET http://localhost:8080/department/{id}/salary/sum
//            — возвращает сумму зарплат по департаменту.
    @GetMapping("department/salary/sum")
    public int getSumSularyTheDepartment(@PathParam("id") int id) {
        return departmentService.getSumSularyTheDepartment(id);
    }

    //    GET http://localhost:8080/department/{id}/salary/max
//            — возвращает максимальную зарплату по департаменту.
    @GetMapping("department/salary/max")
    public OptionalInt getSalaryMaxDepartment(@PathParam("id") int id) {
return departmentService.getSalaryMaxTheDepartment(id);
    }

    //    GET http://localhost:8080/department/{id}/salary/min
//            — возвращает минимальную зарплату по департаменту.
    @GetMapping("department/salary/min")
    public OptionalInt getSalaryMinDepartment(@PathParam("id") int id) {
        return departmentService.getSalaryMinTheDepartment(id);
    }




    //    @RequestMapping(value = "/abc/{id}/def", method = RequestMethod.PUT)
//    void methodA(@PathVariable("id") int id) {}





//    GET http://localhost:8080/department/employees
//            — возвращает сотрудников, сгруппированых по отделам в виде Map<Integer,List<Employees>>,
//    где ключ — это номер отдела, а значение — список сотрудников данного отдела.
}
