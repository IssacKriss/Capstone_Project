package com.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@NotNull
    private String user_name;
	
    @NotNull
    @Column(unique = true)
	private String email;
	
    @NotNull
	private String password;
	
	private String plan;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", 
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;

	public User(int user_id, String user_name, String email, String password, String plan) {
		
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
//		this.plan = plan;
	}
	
	
	
}
