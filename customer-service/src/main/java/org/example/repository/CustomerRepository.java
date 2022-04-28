package org.example.repository;

import org.example.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {

    public void createCustomer(Customer customer) throws SQLException;

    public List<Customer> displayAllCustomers() throws SQLException;

    public Customer getCustomerById(int id) throws SQLException;

    public void updateCustomerFirstNameById(int id) throws SQLException;

    public void updateCustomerLastNameById(int id) throws SQLException;

    public void updateCustomerEmailById(int id) throws SQLException;

    public void deleteCustomerById(int id) throws SQLException;

}
