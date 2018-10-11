package com.jinternal.employee.services;

import com.jinternal.employee.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    Employee updateEmployee(Employee employee);

    Page<Employee> getAllEmployee(Pageable pageable);
}
