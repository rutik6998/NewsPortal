package com.NewsApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.NewsApp.Model.News;
import com.NewsApp.Service.Impl.NewsServicImpl;

@Controller
public class NewsController {
	
	@Autowired
	private NewsServicImpl newsServicImpl;
	

	
	@GetMapping("/addnews")
	public String addNews() {
		return "addnews";
	}
	
	
	@GetMapping("/allnews")
	public ModelAndView getAll() {
		List<News> list = newsServicImpl.getAllNews();
		
		
		return new ModelAndView("allnews","news",list);
	}
	
	
	@PostMapping("/addnews")
	public String addNewNews(@ModelAttribute News news) {
		
		newsServicImpl.addNewNews(news);
		return "redirect:/allnews";
	}
	
	
	
	
@RequestMapping("/deleteNews/{id}")
public String deleteNews(@PathVariable("id") long id) {
	
	newsServicImpl.deleteUserById(id);
	return "redirect:/allnews";
}
	
@RequestMapping("/updateNews/{id}")
public String editBook(@PathVariable("id") long id,Model model) {
	News news = newsServicImpl.getNewsById(id);
	model.addAttribute("news", news);
	return "updatenews";
}

@GetMapping("/userHome")
public String userhome()
{
	return "UserHome";
}

@GetMapping("/userAllNews")
public ModelAndView getAllNews() {
	List<News> list = newsServicImpl.getAllNews();
	
	
	return new ModelAndView("userAllNews","news",list);
}

		
		
}

	
	

