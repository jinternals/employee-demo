package com.jinternal.employee.services;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    Employee updateEmployee(Employee employee) throws ServiceException;

    Page<Employee> getAllEmployee(Pageable pageable);
}
