package com.latindev.EmployeeTest.service;

import com.latindev.EmployeeTest.dto.EmployeeDto;
import com.latindev.EmployeeTest.entity.Employee;
import com.latindev.EmployeeTest.exception.EmployeeNotFoundException;
import com.latindev.EmployeeTest.mapper.EmployeeMapper;
import com.latindev.EmployeeTest.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee  employeeSaved = employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(employeeSaved);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee don't found id: "+ id) );
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::maptoEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee don't found id: "+ id)
        );
        employee.setFirstName(updateEmployee.firstName());
        employee.setLastName(updateEmployee.lastName());
        employee.setAge(updateEmployee.age());
        employee.setEmail(updateEmployee.email());

        employee = employeeRepository.save(employee);

        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee don't found id: "+ id)
        );
        employeeRepository.delete(employee);
    }
}
