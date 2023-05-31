package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.demo.model.User;
import com.spring.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user, Model model, HttpSession session) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
	User usr =	repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(usr !=null) {
				
			session.setAttribute("user", usr);
			session.setMaxInactiveInterval(120);
//			model.addAttribute("uname",user.getUsername());
			return "Home";
		}
		
		model.addAttribute("msg","user not found !!!");
		return "Login";
	}
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}

}
