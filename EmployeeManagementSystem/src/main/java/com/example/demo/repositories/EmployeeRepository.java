package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByNameContainingIgnoreCase(String name);
}
