package com.NewsApp.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NewsApp.Model.Customer;
import com.NewsApp.Repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	
	public void saveUser(Customer cust) {
		
		userRepository.save(cust);
		
	}
	
	public List<Customer> getAllCustomers()
	{
		return userRepository.findAll();
	}
	
	public void deleteUserById(Long id) {
		
		userRepository.deleteById(id);
	}
	
	public Customer getCustById(Long id) {
		return userRepository.findById(id).get();
	}
	
	 public Customer login(String email,String password) {
		 Customer user = userRepository.findByEmailAndPassword(email, password);
		 return user;
	 }
	

	}

	
	
	

