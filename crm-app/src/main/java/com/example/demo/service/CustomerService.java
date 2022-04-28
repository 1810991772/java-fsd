package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomer();

    public Customer createCustomer(Customer customer);

    public void deleteCustomer(int id);

	public Customer findCustomer(int theId);

	public Customer updateCustomer(int id);

}
