package org.example.customer_jdbc;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.customer_jdbc.model.Customer; 
public class App 
{ 
	public static void main( String[] args ) 

{
	try 
	{ 
		//load the driver 
		DriverManager.registerDriver(new org.h2.Driver());
		//second step 
		Connection connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		System.out.println("connection sucessfull: "+connection);
		Statement statement= connection.createStatement();
		ResultSet resultSet= statement.executeQuery("SELECT ID, FNAME,LNAME ,EMAIL FROM CUSTOMERS  ");
		 List<Customer> list = new ArrayList<Customer>();
		while(resultSet.next())
		    { 
			int id=resultSet.getInt(1);
			String Fname=resultSet.getString(2);
			String Lname=resultSet.getString(3);
			String email=resultSet.getString(4);
		list.add(new Customer(id,Fname,Lname,email)); 
			}
		CustomerRepository c=new CustomerRepositoryImpl();
		c.getAllCustomers(list);
	}

	catch (Exception e) { // TODO: handle exception 
		e.printStackTrace(); 
		}
	} 
}

