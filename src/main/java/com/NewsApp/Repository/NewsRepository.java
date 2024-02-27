package com.NewsApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NewsApp.Model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{
	
}