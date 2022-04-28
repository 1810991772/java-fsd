package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer=customerRepository.findById(id).get();
        customerRepository.delete(customer);
    }

	@Override
	public Customer findCustomer(int theId) {
		Customer customer=customerRepository.findById(theId).get();
		return customer;
	}

	@Override
	public Customer updateCustomer(int id) {
		// TODO Auto-generated method stub
		   return   customerRepository.findById(id).get();
		
	}

	
}
