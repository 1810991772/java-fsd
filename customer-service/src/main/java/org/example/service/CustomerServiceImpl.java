package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        customerRepository.createCustomer(customer);
    }

    @Override
    public List<Customer> displayAllCustomers() throws SQLException {
        return customerRepository.displayAllCustomers();
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void updateCustomerFirstNameById(int id) throws SQLException {
        customerRepository.updateCustomerFirstNameById(id);
    }

    @Override
    public void updateCustomerLastNameById(int id) throws SQLException {
        customerRepository.updateCustomerLastNameById(id);
    }

    @Override
    public void updateCustomerEmailById(int id) throws SQLException {
        customerRepository.updateCustomerEmailById(id);
    }

    @Override
    public void deleteCustomerById(int id) throws SQLException {
        customerRepository.deleteCustomerById(id);
    }
}
