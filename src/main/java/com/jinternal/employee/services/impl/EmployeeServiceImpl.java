package com.jinternal.employee.services.impl;

import com.jinternal.employee.entities.Employee;
import com.jinternal.employee.exception.ServiceException;
import com.jinternal.employee.repositories.EmployeeRepository;
import com.jinternal.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        employee.orElseThrow(() -> new RuntimeException(String.format("Employee with id :%s not found", id)));

        return employee.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) throws ServiceException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        if (!optionalEmployee.isPresent()) {
            throw new ServiceException("employee.not.found", Long.toString(employee.getId()));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }


}
