package com.jinternal.employee.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static java.util.Objects.hash;
import static javax.persistence.EnumType.STRING;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(STRING)
    private Gender gender;
    private String department;
    private LocalDate dateOfBirth;


    public Employee() {
    }

    public Employee(String firstName, String lastName, Gender gender, String department, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(department, employee.department) &&
                Objects.equals(dateOfBirth, employee.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return hash(firstName, lastName, gender, department, dateOfBirth);
    }
}
