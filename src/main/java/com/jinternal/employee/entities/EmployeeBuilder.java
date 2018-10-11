package com.jinternal.employee.entities;

import java.time.LocalDate;

public class EmployeeBuilder {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String department;
    private LocalDate dateOfBirth;

    public EmployeeBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public EmployeeBuilder withDepartment(String department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Employee build() {
        return new Employee(firstName, lastName, gender, department, dateOfBirth);
    }

    public static EmployeeBuilder employee(){
        return new EmployeeBuilder();
    }
}