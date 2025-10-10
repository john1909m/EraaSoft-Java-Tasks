package com.spring.boot.service;

import com.spring.boot.dto.EmployeeSpringDto;


import java.util.List;

public interface EmployeeSpringService {

    List<EmployeeSpringDto> getAllEmployees();

    EmployeeSpringDto addEmployee(EmployeeSpringDto teacher);


    EmployeeSpringDto updateEmployee(EmployeeSpringDto teacher);

    void deleteEmployee(Long id);

    EmployeeSpringDto getEmployeeById(Long id);

    EmployeeSpringDto getEmployeeByUserName(String name);

    List<EmployeeSpringDto> searchByNameLikeJPQL(String prefix);
}
