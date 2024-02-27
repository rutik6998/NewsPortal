package com.NewsApp.Model;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String newstitle;
	
	@Column(length = 2000)
	private String newsbody;
	
	private String newscategory;

	private String newslink;
	
	private Timestamp timestamp;
	
	
	
	
	
	
	
	

}
