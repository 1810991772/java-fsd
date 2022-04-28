package org.example.repository;

import org.example.config.MySqlConfig;
import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepositoryImpl implements CustomerRepository {

    Scanner sc = new Scanner(System.in);

    private MySqlConfig mySqlConfig;

    public CustomerRepositoryImpl() {
        mySqlConfig = MySqlConfig.createMySqlConfig();
    }

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        Connection con = mySqlConfig.getMyConnection();

        PreparedStatement pStatement = con.prepareStatement("insert into Customer(customerID, First_Name, Last_Name, Email) values(?, ?, ?, ?)");

        pStatement.setInt(1, customer.getCustomerId());
        pStatement.setString(2, customer.getFirstName());
        pStatement.setString(3, customer.getLastName());
        pStatement.setString(4, customer.getEmail());
        pStatement.executeUpdate();

        System.out.println("Customer created successfully...");

    }

    @Override
    public List<Customer> displayAllCustomers() throws SQLException {
        List<Customer> list = new ArrayList<Customer>();
        Connection con = mySqlConfig.getMyConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select customerID, First_Name, Last_Name, Email from Customer");

        while(rs.next()) {
            Customer customer = new Customer();

            customer.setCustomerId(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setEmail(rs.getString(4));

            list.add(customer);
        }

        return list;
    }

    @Override
    public Customer getCustomerById(int id) throws SQLException {
        List<Customer> list = new ArrayList<Customer>();
        Connection con = mySqlConfig.getMyConnection();
        PreparedStatement pstatement = con.prepareStatement("select customerID, First_Name, Last_Name, Email from Customer where customerID=?");
        pstatement.setInt(1, id);

        ResultSet rs = pstatement.executeQuery();

        while(rs.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setEmail(rs.getString(4));

            list.add(customer);
        }

        if(list.isEmpty()) {
            return null;
        }
        else {
            return list.get(0);
        }

    }

    @Override
    public void updateCustomerFirstNameById(int id) throws SQLException {
        System.out.println("Enter New First Name: ");
        String fName = sc.next();
        Connection con = mySqlConfig.getMyConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE customer SET First_Name = ? WHERE customerID = ?");
        pst.setString(1, fName);
        pst.setInt(2, id);

        pst.executeUpdate();

        System.out.println("Customer First Name updated successfully...");
    }

    @Override
    public void updateCustomerLastNameById(int id) throws SQLException {
        System.out.println("Enter New Last Name: ");
        String lName = sc.next();
        Connection con = mySqlConfig.getMyConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE customer SET Last_Name = ? WHERE customerID = ?");

        pst.setString(1, lName);
        pst.setInt(2, id);

        pst.executeUpdate();

        System.out.println("Customer Last Name updated successfully...");
    }

    @Override
    public void updateCustomerEmailById(int id) throws SQLException {
        System.out.println("Enter New Email: ");
        String email = sc.next();
        Connection con = mySqlConfig.getMyConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE customer SET Email = ? WHERE customerID = ?");

        pst.setString(1, email);
        pst.setInt(2, id);
        pst.executeUpdate();

        System.out.println("Customer email updated successfully...");
    }

    @Override
    public void deleteCustomerById(int id) throws SQLException {
        Connection con = mySqlConfig.getMyConnection();
        PreparedStatement pst = con.prepareStatement("delete from customer where customerID = ?;");
        pst.setInt(1, id);
        pst.executeUpdate();

        System.out.println("Customer Deleted Successfully...");
    }
}
