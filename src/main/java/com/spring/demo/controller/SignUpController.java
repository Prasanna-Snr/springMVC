package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.demo.model.User;
import com.spring.demo.repository.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/signup")
	public String getSignUpPage() {
		return "SignUp";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		repo.save(user);
		return "Login";
	}

}
