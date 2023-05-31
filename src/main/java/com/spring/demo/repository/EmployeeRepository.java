package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
