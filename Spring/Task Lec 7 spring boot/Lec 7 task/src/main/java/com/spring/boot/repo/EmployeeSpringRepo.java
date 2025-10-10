package com.spring.boot.repo;

import com.spring.boot.dto.EmployeeSpringDto;
import com.spring.boot.model.EmployeeSpring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeSpringRepo extends JpaRepository<EmployeeSpring, Long> {
    Optional<EmployeeSpring> findByname(String userName);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE CONCAT(:namePrefix, '%')")
    List<EmployeeSpringDto> findByNamePrefix(@Param("namePrefix") String userName);




}
