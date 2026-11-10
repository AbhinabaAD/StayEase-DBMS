package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByBranch_BranchId(Integer branchId);

    List<Employee> findByDesignationIgnoreCase(String designation);

    Optional<Employee> findByEmail(String email);
}