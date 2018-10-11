package com.jinternal.employee.controllers;

import com.jinternal.employee.dto.EmployeeRequestDto;
import com.jinternal.employee.dto.EmployeeResponseDto;
import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.exception.RestException;
import com.jinternal.employee.exception.ServiceException;
import com.jinternal.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.jinternal.employee.dto.EmployeeRequestDto.fromRequest;
import static com.jinternal.employee.dto.EmployeeResponseDto.toResponse;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    @ResponseBody
    public EmployeeResponseDto registerEmployee(@RequestBody @Valid EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeService.saveEmployee(fromRequest(employeeRequestDto));
        return toResponse(employee);
    }

    @GetMapping("/employee")
    @ResponseBody
    public Page<EmployeeResponseDto> getAllEmployees(Pageable pageable) {
        Page<Employee> employeePage = employeeService.getAllEmployee(pageable);
        return toPageResponse(pageable, employeePage);
    }

    @PutMapping("/employee/{id}")
    @ResponseBody
    public EmployeeResponseDto updateEmployee(@PathVariable("id") Long id,
                                                @RequestBody @Valid EmployeeRequestDto employeeRequestDto) throws RestException {
        try {
            Employee employee = fromRequest(employeeRequestDto);
            employee.setId(id);
            employee = employeeService.updateEmployee(employee);
            return toResponse(employee);
        } catch (ServiceException e) {
            throw new RestException(e);
        }

    }

    private PageImpl<EmployeeResponseDto> toPageResponse(Pageable pageable, Page<Employee> employee) {
        return new PageImpl(toResponse(employee.getContent()), pageable, employee.getTotalElements());
    }
}
