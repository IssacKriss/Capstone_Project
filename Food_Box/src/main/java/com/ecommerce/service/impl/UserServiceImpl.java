package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserRepository;
import com.ecommerce.exception.BussinessException;
import com.ecommerce.model.Role;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository dao;
	
	@Override
	public User authenticate(String user_id, String password) {
		
		return null;
	}

	@Override
	public User addUser(User user) throws BussinessException {
		String tempEmail = user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail) )
		{
			User userObj = dao.findByEmail(tempEmail);
			if(userObj != null ) {
				throw new BussinessException("User with "+tempEmail+" is already existsing. Please login");
			}
		}
		return dao.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return dao.save(user);
	}

	@Override
	public User getUserById(int user_id) {
		
		return dao.findById(user_id).get();
	}

	@Override
	public void deleteUserById(int user_id) {
		
		dao.deleteById(user_id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return dao.findAll();
	}

	@Override
	public List<User> getAllUsersByPlan(String plan) {
		
		return null;
	}

	@Override
	public User loginUser(String email, String password) throws BussinessException {
		
		User userObj = null;
		
		if(email !=null && password !=null) {
		    userObj = dao.findByEmailAndPassword(email, password);
			String tempEmail = userObj.getEmail();
			String tempPassword = userObj.getPassword(); 
			if(tempEmail==email && tempPassword!=password) {
				throw new BussinessException("Password is wrong. Plase enter correct password");
			}
		}
			if(userObj == null) {
				throw new BussinessException("No User with email id "+email+" exist. Please Register");
			}
//			else if(tempEmail==email && tempPassword!=password) {
//				throw new BussinessException("Password is wrong. Plase enter correct password");
//			}
		
		
		return userObj;
			
	}

    

}
