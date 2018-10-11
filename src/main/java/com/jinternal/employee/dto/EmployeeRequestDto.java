package com.jinternal.employee.dto;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.entities.EmployeeBuilder;
import com.jinternal.employee.validators.Gender;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class EmployeeRequestDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Gender(message = "Allowed values are MALE and FEMALE")
    private String gender;

    @NotEmpty
    private String department;

    @NotNull
    private LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static Employee from(EmployeeRequestDto employeeRequestDto){

       return EmployeeBuilder
               .employee()
               .withFirstName(employeeRequestDto.firstName)
               .withLastName(employeeRequestDto.lastName)
               .withGender(com.jinternal.employee.entities.Gender.valueOf(employeeRequestDto.gender))
               .withDepartment(employeeRequestDto.department)
               .withDateOfBirth(employeeRequestDto.dateOfBirth)
               .build();

    }

    public static EmployeeRequestDto to(Employee employee){

        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
        employeeRequestDto.setFirstName(employee.getFirstName());
        employeeRequestDto.setLastName(employee.getLastName());
        employeeRequestDto.setDepartment(employee.getDepartment());
        employeeRequestDto.setDateOfBirth(employee.getDateOfBirth());
        employeeRequestDto.setGender(employee.getGender().toString());

        return employeeRequestDto;
    }
}
