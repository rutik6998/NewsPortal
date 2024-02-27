package com.NewsApp.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.NewsApp.Model.Customer;
import com.NewsApp.Service.Impl.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Email;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public String HomePage() {
		
		return "index";
	
	}
	
	@GetMapping("/admin")
	public String HomePageAdmin() {
		
		return "admindash";
	
	}
	@GetMapping("/adduser")
	public String addUserPage() {
		
		return "adduser";
		
	}
	
	
	@GetMapping("/userlist")
	public ModelAndView getAllCustomers() {
		List<Customer> list = userServiceImpl.getAllCustomers();
		
		
		return new ModelAndView("userlist","customer",list);
		
	}
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		
		userServiceImpl.deleteUserById(id);
		return "redirect:/userlist";
	}
	
	@PostMapping("/adduser")
	public String AddUser(@ModelAttribute Customer cust)
	{
		userServiceImpl.saveUser(cust);
		return "redirect:/userlist";
		
		
		
		
	}
	
	@RequestMapping("/updateUser/{id}")
	public String editUser(@PathVariable("id") long id,Model model) {
		
		Customer customer = userServiceImpl.getCustById(id);
		model.addAttribute("customer", customer);
		return "updateuser";
		
	}
	
	
	
	@GetMapping("/userHome/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("user",new Customer());
		return mv;
	}
	
	
	@PostMapping("/userHome/login")
	public String login(@ModelAttribute("user") Customer user) {
		Customer auth = userServiceImpl.login(user.getEmail(), user.getPassword());
		
		//System.out.println(auth);
		
		if(Objects.nonNull(auth)) {
			
			return "redirect:/userAllNews";
		}
		else {
			return "redirect:/userHome/login";
		}
		
	}
	
	@RequestMapping(value= {"/logout"},method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request,HttpServletResponse response) {
		
		return "redirect:/userHome/login";
	}
	
	
	@GetMapping("/userHome/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/userHome/register")
	public String registerUser(@ModelAttribute Customer cust)
	{
		userServiceImpl.saveUser(cust);
		
		if(cust!=null)
		{
			return "redirect:/userHome/login";

			
		}else {
			return "redirect:/userHome/register";
		}
	
		
	}

	@GetMapping("/adminLogin")
	public String adminLogin() {
		
		return "adminLogin";
	}

}
