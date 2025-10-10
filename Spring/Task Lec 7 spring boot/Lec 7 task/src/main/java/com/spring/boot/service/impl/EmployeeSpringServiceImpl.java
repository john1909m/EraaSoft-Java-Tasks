package com.spring.boot.service.impl;

import com.spring.boot.dto.EmployeeSpringDto;
import com.spring.boot.model.EmployeeSpring;
import com.spring.boot.repo.EmployeeSpringRepo;
import com.spring.boot.service.EmployeeSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeSpringServiceImpl implements EmployeeSpringService {

    EmployeeSpringRepo employeeSpringRepo;

    @Autowired
    public EmployeeSpringServiceImpl(EmployeeSpringRepo employeeSpringRepo) {
        this.employeeSpringRepo = employeeSpringRepo;
    }
    @Override
    public List<EmployeeSpringDto> getAllEmployees() {
        List<EmployeeSpring> employeeSprings = employeeSpringRepo.findAll();

        return employeeSprings.stream().map(employeeSpring ->
                        new EmployeeSpringDto(employeeSpring.getId(), employeeSpring.getName(), employeeSpring.getAge(),employeeSpring.getPhoneNumber()))
                        .collect(Collectors.toList());
    }

    @Override
    public EmployeeSpringDto addEmployee(EmployeeSpringDto employeeSpringDto) {
        if(Objects.nonNull(employeeSpringDto.getId())){
            throw new RuntimeException("id must be null");
        }
        if(Objects.isNull(employeeSpringDto.getName())){
            throw new RuntimeException("user name must be not null");
        }
        if(Objects.isNull(employeeSpringDto.getAge())){
            throw new RuntimeException("Age must be not null");
        }
        if(Objects.isNull(employeeSpringDto.getPhoneNumber())){
            throw new RuntimeException("Age must be not null");
        }
        Optional<EmployeeSpring> EmployeeSpringOptional = employeeSpringRepo.findByname(employeeSpringDto.getName());
        if(EmployeeSpringOptional.isPresent()){
            throw new RuntimeException("teacher is already exist with same username");
        }
        EmployeeSpring employeeSpring = employeeSpringRepo.save(new EmployeeSpring(employeeSpringDto.getName(),employeeSpringDto.getAge(),employeeSpringDto.getPhoneNumber()));

        employeeSpringDto.setId(employeeSpring.getId());

        return employeeSpringDto;
    }

    @Override
    public List<EmployeeSpringDto> addEmployees(List<EmployeeSpringDto> employees) {
        List<EmployeeSpring> entities=employees.stream()
                .map(employeeSpring ->new EmployeeSpring(employeeSpring.getName(),employeeSpring.getAge(),employeeSpring.getPhoneNumber()))
                .collect(Collectors.toList());

        return employeeSpringRepo.saveAll(entities).stream()
                .map(employeeSpring ->new EmployeeSpringDto(employeeSpring.getId(), employeeSpring.getName(), employeeSpring.getAge(),employeeSpring.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeSpringDto updateEmployee(EmployeeSpringDto employeeSpringDto) {
        if(Objects.isNull(employeeSpringDto.getId())){
            throw new RuntimeException("id must be not null");
        }
        EmployeeSpring employeeSpring = employeeSpringRepo.save(new EmployeeSpring(employeeSpringDto.getId(),employeeSpringDto.getName(),employeeSpringDto.getAge(),employeeSpringDto.getPhoneNumber()));
        return employeeSpringDto;
    }

    @Override
    public List<EmployeeSpringDto> updateEmployees(List<EmployeeSpringDto> employees) {
        List<EmployeeSpring> entities = employees.stream()
                .map(e -> new EmployeeSpring(e.getId(), e.getName(), e.getAge(), e.getPhoneNumber()))
                .collect(Collectors.toList());
        return employeeSpringRepo.saveAll(entities)
                .stream()
                .map(e -> new EmployeeSpringDto(e.getId(), e.getName(), e.getAge(), e.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<EmployeeSpring> employeeSpringOptional = employeeSpringRepo.findById(id);
        if(employeeSpringOptional.isEmpty()){
            throw new RuntimeException("employee not found");
        }
        employeeSpringRepo.deleteById(id);
    }

    @Override
    public void deleteAllEmployees() {
        employeeSpringRepo.deleteAll();
    }

    @Override
    public void deleteEmployeesByIds(List<Long> ids) {
        employeeSpringRepo.deleteAllById(ids);
    }

    @Override
    public List<EmployeeSpringDto> getEmployeesByIds(List<Long> ids) {
        return employeeSpringRepo.findAllById(ids)
                .stream()
                .map(e -> new EmployeeSpringDto(e.getId(), e.getName(), e.getAge(), e.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeSpringDto getEmployeeById(Long id) {
        Optional<EmployeeSpring> employeeSpringOptional = employeeSpringRepo.findById(id);
        if(employeeSpringOptional.isEmpty()){
            throw new RuntimeException("employee not found");
        }
        EmployeeSpring employeeSpring =employeeSpringOptional.get();
        return new EmployeeSpringDto(employeeSpring.getId(), employeeSpring.getName(), employeeSpring.getAge(),employeeSpring.getPhoneNumber());
    }

    @Override
    public EmployeeSpringDto getEmployeeByUserName(String name) {
        Optional<EmployeeSpring> employeeSpringOptional = employeeSpringRepo.findByname(name);
        if(employeeSpringOptional.isEmpty()){
            throw new RuntimeException("teacher not found");
        }
        EmployeeSpring employeeSpring =employeeSpringOptional.get();
        return new EmployeeSpringDto(employeeSpring.getId(), employeeSpring.getName(), employeeSpring.getAge(),employeeSpring.getPhoneNumber());
    }
    @Override
    public List<EmployeeSpringDto> searchByNameLikeJPQL(String prefix) {
        return employeeSpringRepo.findByNamePrefix(prefix);
    }

}
