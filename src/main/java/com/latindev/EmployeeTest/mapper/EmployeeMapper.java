package com.latindev.EmployeeTest.mapper;

import com.latindev.EmployeeTest.dto.EmployeeDto;
import com.latindev.EmployeeTest.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto maptoEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAge()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.id(),
                employeeDto.firstName(),
                employeeDto.lastName(),
                employeeDto.email(),
                employeeDto.age()
        );
    }
}
