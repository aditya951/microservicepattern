package com.twitter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.demo.model.Login;
import com.twitter.demo.model.User;
import com.twitter.demo.service.UserSvc;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {
	
	
	@Autowired
	UserSvc usersvc;
	
	@PostMapping("/register")
	public User createTwitter(@RequestBody User user) {

		return usersvc.createuser(user);
	}

	@GetMapping("/users/all")
	public List<User> getAllUser() {
		return usersvc.getAllUsers();
	}
	
	@GetMapping("/users/{username}")
	public User getusername(@PathVariable String username) {
		return usersvc.getUsername(username);
	}
	
	
	@PostMapping("/login")
	public User loginTwitter(@RequestBody Login login) {

		return usersvc.loginuser(login);
	}
}
