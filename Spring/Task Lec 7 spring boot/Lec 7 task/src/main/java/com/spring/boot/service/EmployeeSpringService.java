package com.spring.boot.service;

import com.spring.boot.dto.EmployeeSpringDto;


import java.util.List;

public interface EmployeeSpringService {

    List<EmployeeSpringDto> getAllEmployees();

    EmployeeSpringDto addEmployee(EmployeeSpringDto teacher);

    List<EmployeeSpringDto> addEmployees(List<EmployeeSpringDto> employees);

    EmployeeSpringDto updateEmployee(EmployeeSpringDto teacher);

    List<EmployeeSpringDto> updateEmployees(List<EmployeeSpringDto> employees);

    void deleteEmployee(Long id);

    void deleteAllEmployees();

    void deleteEmployeesByIds(List<Long> ids);

    List<EmployeeSpringDto> getEmployeesByIds(List<Long> ids);

    EmployeeSpringDto getEmployeeById(Long id);

    EmployeeSpringDto getEmployeeByUserName(String name);

    List<EmployeeSpringDto> searchByNameLikeJPQL(String prefix);
}
