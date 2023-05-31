package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.model.Employee;
import com.spring.demo.services.IEmployee;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployee service;
	
	
	@GetMapping("/employee")
	public String getForm() {
		return "EmployeeForm";
	}
	
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute Employee emp) {
		service.addEmployee(emp);
		return "EmployeeForm";
	}
	
	@GetMapping("/empList")
	public String getAllEmp(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "Login";
		}
		
		
		model.addAttribute("allEmp",service.getAllEmployee());
		
		return "EmpList";
	}
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam int id) {
		service.deleteEmp(id);
		return "redirect:/empList";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id,Model model) {
		model.addAttribute("emodel",service.getEmployee(id));
		return"EditForm";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp) {
		service.updateEmp(emp);
		return "redirect:/empList";
	}

}
