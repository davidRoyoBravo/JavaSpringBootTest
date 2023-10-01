package com.latindev.EmployeeTest.service;

import com.latindev.EmployeeTest.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Integer id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Integer id, EmployeeDto updateEmployee);
    void deleteEmployee(Integer id);
}
