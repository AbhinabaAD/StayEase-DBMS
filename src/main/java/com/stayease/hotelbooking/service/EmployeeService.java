package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.Employee;
import com.stayease.hotelbooking.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByBranch(Integer branchId) {
        return employeeRepository.findByBranch_BranchId(branchId);
    }

    public List<Employee> getEmployeesByDesignation(String designation) {
        return employeeRepository.findByDesignationIgnoreCase(designation);
    }

    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}