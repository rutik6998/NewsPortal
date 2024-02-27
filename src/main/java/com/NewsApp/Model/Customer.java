package com.NewsApp.Model;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank()
	private String fullname;
	
	@NotBlank()
	
	private Long mobile;
	
	@NotBlank
	private String city;
	
	@NotBlank()
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String password;
	
	

}
