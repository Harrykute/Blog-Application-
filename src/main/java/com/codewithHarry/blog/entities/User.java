package com.codewithHarry.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity   // setting as entity with @Entity Annotation
@Table(name="users") // table name specifying
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id  // Setting as primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) // generate value Auto
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name",nullable=false,length=100)
	private String name;

	@Column(name="user_email",length = 100)
	private String email;
	
	@Column(name="user_pass")
	private String password;
	
	@Column(name="about")
	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();
	
}
