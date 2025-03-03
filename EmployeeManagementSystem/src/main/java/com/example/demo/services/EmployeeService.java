package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return employee;
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> searchEmployees(String name) {
        if (name != null && !name.isEmpty()) {
            return employeeRepository.findByNameContainingIgnoreCase(name);
        }
        return employeeRepository.findAll();
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
