package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.BussinessException;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("user/login")
	public User authenticate(@RequestBody User user) throws BussinessException {
		
		String email = user.getEmail();
		String password = user.getPassword();
		return service.loginUser(email, password);
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) throws BussinessException {
		
		 return service.addUser(user);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		
		return service.updateUser(user);
	}

	@GetMapping("/user/{user_id}")
	public User getUserById(@PathVariable int user_id) {
		
		return service.getUserById(user_id);
	}

	@DeleteMapping("/user/{user_id}")
	public void deleteUserById(@PathVariable int user_id) {
		
		service.deleteUserById(user_id);		
	}

	
	@GetMapping("/users")
	public List<User> getAllUsers(){
			
		return service.getAllUsers();
	}

	
	public List<User> getAllUsersByPlan(String plan) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
