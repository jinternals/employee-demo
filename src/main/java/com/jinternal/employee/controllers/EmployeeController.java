package com.jinternal.employee.controllers;

import com.jinternal.employee.dto.EmployeeRequestDto;
import com.jinternal.employee.dto.EmployeeResponseDto;
import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import static com.jinternal.employee.dto.EmployeeRequestDto.from;
import static com.jinternal.employee.dto.EmployeeResponseDto.toDto;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    @ResponseBody
    public EmployeeResponseDto saveEmployee(@RequestBody @Valid EmployeeRequestDto employeeRequestDto){
        Employee employee = employeeService.saveEmployee(from(employeeRequestDto));
        return toDto(employee);
    }

    @GetMapping("/employee")
    @ResponseBody
    public Page<EmployeeResponseDto> saveEmployee(Pageable pageable){
        Page<Employee> employeePage = employeeService.getAllEmployee(pageable);
        return toPageResponse(pageable, employeePage);

    }

    @PutMapping("/employee/{id}")
    @ResponseBody
    public EmployeeResponseDto saveEmployee(@PathVariable("id") Long id, @RequestBody @Valid EmployeeRequestDto employeeRequestDto){
        Employee employee = from(employeeRequestDto);
        employee.setId(id);
        employee = employeeService.updateEmployee(employee);
        return toDto(employee);
    }

    private PageImpl<EmployeeResponseDto> toPageResponse(Pageable pageable, Page<Employee> employee) {
        return new PageImpl<EmployeeResponseDto>(EmployeeResponseDto.toDto(employee.getContent()), pageable, employee.getTotalElements());
    }
}
