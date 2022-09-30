package com.twitter.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.demo.model.Login;
import com.twitter.demo.model.User;
import com.twitter.demo.repository.UserRepository;

@Service
public class UserSvc {

	@Autowired
	UserRepository userRepository;

	public User createuser(User user) {

		User newUser=new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		newUser.setContactNo(user.getContactNo());
		newUser.setProfileImage(user.getProfileImage());
		return userRepository.save(newUser);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getUsername(String username) {
		User findByusername = userRepository.findByUsername(username);
		return findByusername;
	}

	public User loginuser(Login login) {
		User findByusername = userRepository.findByUsername(login.getUsername());
		if (findByusername != null) {
			if (findByusername.getPassword().equals(login.getPassword())) {
				return findByusername;
			}
		}
		return new User();
	}
	public User resetuser(Login login) {
		User findByusername = userRepository.findByUsername(login.getUsername());
		if (findByusername != null) {
			findByusername.setPassword(login.getPassword());
			User save = userRepository.save(findByusername);
			return save;
			}
		
		return new User();
	}

}
