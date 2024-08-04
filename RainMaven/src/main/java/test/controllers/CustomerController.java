package test.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import MVC_First.MVC_First.services.UserService;
import test.Dao.CustomerDao;
import test.beans.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerDao cd;
	
	
	@RequestMapping("/sky")
	public void get()
	{
		System.out.println("Wellos");
	}

	
   //about page
	@RequestMapping("/about")
	public String one(Model m)
	{
		
		List<Customer> l1=cd.displayinfo();
		
		m.addAttribute("x",l1);
		return "about";
	}
	
	
	@RequestMapping("/register")
	public String two()
	{
		return "register";
	}
	
	
	
	@RequestMapping("/savecustomerinfo")
	public String three(@ModelAttribute("c1") Customer c1)
	{
		
		if(c1.getCpass().equals(c1.getCcpass()))
		{

			cd.registerinfo(c1);
		
			return  "redirect:/login";	
    	}
	
			return "register";
	}
	
	
	
	//delete data 
	
	@RequestMapping ("/deletdata/{id}")
	public String four(@PathVariable int id)
	{
		
		cd.deleteinfo(id);
		return "redirect:/about";
	}
	
	
	//edit data
	@RequestMapping("/editdata/{id}")
	public String Five(@PathVariable int id,Model c)
	{
		
		List<Customer> c1=cd.editdata(id);
		c.addAttribute("kk",c1);
		return "editPage";
	}
	
	
	//update data show
	@RequestMapping("/updatecustomerinfo")
	public String six(@ModelAttribute("c1") Customer c1)
	{
		if(c1.getCcpass().equals(c1.getCpass()))
		{
			cd.updatecustomerinfo(c1);
			
			return "redirect:/about";
		}
		return "register";
		
		
	}
	

	}


	
	
