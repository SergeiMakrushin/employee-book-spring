package com.skypro.employee.model;

import com.skypro.employee.record.EmployeeRequest;

public class Employee {

    private static int couter;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int departament;
    private final int salary;



    public Employee(String firstName, String lastName, int departament, int salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
        this.salary = salary;
        this.id=++couter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartament() {
        return departament;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departament=" + departament +
                ", salary=" + salary +
                '}';
    }
}
