package org.example.demo.controller;

import java.util.List;

import org.example.demo.model.Customer;
import org.example.demo.repo.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping
	public String home(Model theModel)
	{
		// get customers from the dao
				List<Customer> theCustomers = customerDAO.getCustomers();
						
				// add the customers to the model
				theModel.addAttribute("customers", theCustomers);
				System.out.println("Customers:  "+theCustomers);
				
				return "home";
	}
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}


