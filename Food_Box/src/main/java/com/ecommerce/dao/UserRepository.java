package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String password);
}