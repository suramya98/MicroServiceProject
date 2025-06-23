package com.example.EmployeeModule.repository;


import com.example.EmployeeModule.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
