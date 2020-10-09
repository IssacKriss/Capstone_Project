package com.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	
	private String role_name;
	
//	@ManyToMany(mappedBy = "roles")
//	private List<User> users;

	public Role(String role_name) {
		this.role_name = role_name;
	}
	
	
}
