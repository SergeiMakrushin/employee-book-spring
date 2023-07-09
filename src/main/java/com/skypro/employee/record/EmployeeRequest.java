package com.skypro.employee.record;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class EmployeeRequest {


    private String firstName;
    private String lastName;
    private int departament;
    private int salary;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

        if (firstName != null || StringUtils.isNotEmpty(firstName) ||
                StringUtils.isNotBlank(firstName) ||
                StringUtils.isAlphaSpace(firstName)) {
            this.firstName = StringUtils.capitalize(firstName);
        } else {
            throw new RuntimeException("400 Bad Request");
        }

    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        if (lastName != null || StringUtils.isNotEmpty(lastName) ||
                StringUtils.isNotBlank(lastName) ||
                StringUtils.isAlphaSpace(lastName)) {
            this.lastName = StringUtils.capitalize(lastName);
        } else {
            throw new RuntimeException("400 Bad Request");
        }

    }


    public int getDepartament() {
        return departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeRequest that = (EmployeeRequest) o;
        return departament == that.departament && salary == that.salary && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departament, salary);
    }
}
