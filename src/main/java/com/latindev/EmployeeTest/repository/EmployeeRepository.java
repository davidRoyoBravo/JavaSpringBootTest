package com.latindev.EmployeeTest.repository;

import com.latindev.EmployeeTest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
