package org.example.demo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
public class App 
{ 
	public static void main( String[] args ) 

{
	try 
	{ //load the driver 
		DriverManager.registerDriver(new org.h2.Driver());
		//second step 
		Connection connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		System.out.println("connection sucessfull: "+connection);
		DatabaseMetaData s = connection.getMetaData(); 
		System.out.println(s.getDatabaseProductName());
		Statement statement= connection.createStatement();
		ResultSet resultSet= statement.executeQuery("SELECT * FROM EMPLOYEE ");
		while(resultSet.next())
		    { 
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)); 
			}
	}

	catch (Exception e) { // TODO: handle exception 
		e.printStackTrace(); 
		}
	} 
}

