package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.BussinessException;
import com.ecommerce.model.User;

public interface UserService {
	
	public User authenticate(String user_id, String password);
	
//	public void createUser(User user);
//	
//	public void createAdmin(User user);
	
    public User addUser(User user) throws BussinessException;
    
    public User loginUser(String email, String password) throws BussinessException; 
     
 	public User updateUser(User user);
	
 	public User getUserById(int user_id);
 	
 	public void deleteUserById(int user_id);
 	
 	public List<User> getAllUsers();
 	
 	public List<User> getAllUsersByPlan(String plan);
 	
}
