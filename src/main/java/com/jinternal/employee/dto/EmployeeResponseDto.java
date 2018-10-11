package com.jinternal.employee.dto;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.entities.EmployeeBuilder;
import com.jinternal.employee.entities.Gender;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeResponseDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String department;

    private LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static Employee from(EmployeeResponseDto employeeRequestDto) {

        return EmployeeBuilder
                .employee()
                .withFirstName(employeeRequestDto.firstName)
                .withLastName(employeeRequestDto.lastName)
                .withGender(Gender.valueOf(employeeRequestDto.gender))
                .withDepartment(employeeRequestDto.department)
                .build();

    }

    public static EmployeeResponseDto toResponse(Employee employee) {

        EmployeeResponseDto employeeRequestDto = new EmployeeResponseDto();
        employeeRequestDto.setId(employee.getId());
        employeeRequestDto.setFirstName(employee.getFirstName());
        employeeRequestDto.setLastName(employee.getLastName());
        employeeRequestDto.setDepartment(employee.getDepartment());
        employeeRequestDto.setDateOfBirth(employee.getDateOfBirth());
        employeeRequestDto.setGender(employee.getGender().toString());

        return employeeRequestDto;
    }

    public static List<EmployeeResponseDto> toResponse(List<Employee> employee) {
        return employee
                .stream()
                .map(emp -> toResponse(emp))
                .collect(toList());

    }
}
