package com.NewsApp.Service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.NewsApp.Model.News;
import com.NewsApp.Repository.NewsRepository;


@Service
public class NewsServicImpl{

	@Autowired
	private NewsRepository newsRepository;

	public NewsServicImpl(NewsRepository newsRepository) {
		super();
		this.newsRepository = newsRepository;
	}

	public void addNewNews(News news) {

		news.setTimestamp(new Timestamp(new Date().getTime()));
		newsRepository.save(news);
	}

	public List<News> getAllNews() {
		return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	public News getNewsById(long id) {
		return newsRepository.findById(id).get();

	}

	public News updateNews(News news) {
		return newsRepository.save(news);
	}

	public void deleteUserById(Long id) {

		newsRepository.deleteById(id);
	}

}
