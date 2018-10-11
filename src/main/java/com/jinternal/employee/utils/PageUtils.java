package com.jinternal.employee.utils;

import com.jinternal.employee.dto.EmployeeResponseDto;
import com.jinternal.employee.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PageUtils {

    public static PageImpl<EmployeeResponseDto> toPageResponse(Pageable pageable, Page<Employee> employee) {
        return new PageImpl<EmployeeResponseDto>(EmployeeResponseDto.toResponse(employee.getContent()), pageable, employee.getTotalElements());
    }
}
