package com.spring.demo.services;

import java.util.List;

import com.spring.demo.model.Employee;

public interface IEmployee {
	
	void addEmployee(Employee emp);
	
	void deleteEmp(int id);
	
	void updateEmp(Employee emp);
	
	Employee getEmployee(int id);
	
	List<Employee> getAllEmployee();

}
