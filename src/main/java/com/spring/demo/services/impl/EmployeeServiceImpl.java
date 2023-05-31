package com.spring.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.model.Employee;
import com.spring.demo.repository.EmployeeRepository;
import com.spring.demo.services.IEmployee;
@Service
public class EmployeeServiceImpl implements IEmployee{
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmployee(int id) {
		
		return empRepo.getById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

}
