package com.NewsApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NewsApp.Model.Customer;



@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {
	
	Customer findByEmailAndPassword(String email, String password);

}
