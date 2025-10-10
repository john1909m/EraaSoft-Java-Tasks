package com.spring.boot.controller;

import com.spring.boot.dto.EmployeeSpringDto;
import com.spring.boot.service.EmployeeSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeSpringController {

    private EmployeeSpringService employeeSpringService;

    @Autowired
    public void TeacherController(EmployeeSpringService employeeSpringService) {
        this.employeeSpringService = employeeSpringService;
    }

    @GetMapping("/employees")
    public List<EmployeeSpringDto> getEmployees() {
        return employeeSpringService.getAllEmployees();

    }

    @PostMapping("/employee/add")
    public EmployeeSpringDto addEmployee(@RequestBody EmployeeSpringDto employeeSpringDto) {
        return employeeSpringService.addEmployee(employeeSpringDto);

    }

    @PutMapping("/employee/update")
    public EmployeeSpringDto updateEmployee(@RequestBody EmployeeSpringDto employeeSpringDto) {
        return employeeSpringService.updateEmployee(employeeSpringDto);

    }
    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeSpringService.deleteEmployee(id);

    }

    @GetMapping("/employee")
    public EmployeeSpringDto getEmployeeById(@RequestParam Long id) {
        return employeeSpringService.getEmployeeById(id);

    }


    @GetMapping("/employee/name")
    public EmployeeSpringDto getTeacherByName(@RequestParam String name) {
        return employeeSpringService.getEmployeeByUserName(name);

    }

    @GetMapping("/employee/search")
    public List<EmployeeSpringDto> searchByNameJPQL(@RequestParam String name) {
        return employeeSpringService.searchByNameLikeJPQL(name);
    }

}
