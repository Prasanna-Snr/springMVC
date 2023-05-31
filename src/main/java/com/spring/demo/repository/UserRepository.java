package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	 User findByUsernameAndPassword(String un, String psw);

}
