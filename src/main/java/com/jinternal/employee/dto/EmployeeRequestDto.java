package com.jinternal.employee.dto;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.entities.EmployeeBuilder;
import com.jinternal.employee.validators.Gender;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.jinternal.employee.configuration.EmployeeConfiguration.DATE_FORMATTER;
import static com.jinternal.employee.configuration.EmployeeConfiguration.DATE_FORMAT;
import static java.time.LocalDate.parse;

public class EmployeeRequestDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Gender
    private String gender;

    @NotEmpty
    private String department;

    @NotNull
    private String dateOfBirth;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static Employee fromRequest(EmployeeRequestDto requestDto) {

        return EmployeeBuilder
                .employee()
                .withFirstName(requestDto.firstName)
                .withLastName(requestDto.lastName)
                .withGender(com.jinternal.employee.entities.Gender.valueOf(requestDto.gender))
                .withDepartment(requestDto.department)
                .withDateOfBirth(parse(requestDto.dateOfBirth, DATE_FORMATTER))
                .build();

    }

    public static EmployeeRequestDto to(Employee employee) {

        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
        employeeRequestDto.setFirstName(employee.getFirstName());
        employeeRequestDto.setLastName(employee.getLastName());
        employeeRequestDto.setDepartment(employee.getDepartment());
        employeeRequestDto.setDateOfBirth(employee.getDateOfBirth().format(DATE_FORMATTER));
        employeeRequestDto.setGender(employee.getGender().toString());

        return employeeRequestDto;
    }
}
