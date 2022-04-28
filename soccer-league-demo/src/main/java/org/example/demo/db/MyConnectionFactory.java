package org.example.demo.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionFactory {
	
	
	private Connection connection;
	
	private static MyConnectionFactory myConnectionFactory;
	
	
	public MyConnectionFactory()
	{
		
	}
	
	
	public   Connection getMyConnection()throws SQLException
	{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
		return connection;
	}

	
	public static MyConnectionFactory createMyConnectionFactory()
	{
		if(myConnectionFactory==null)
		{
			myConnectionFactory=new MyConnectionFactory();
			
		}
		return myConnectionFactory;
		
	}
	
}
