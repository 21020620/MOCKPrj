package com.example.carparkdemo.repository;

import com.example.carparkdemo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface HRStaffRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByAccount(String account);

}
