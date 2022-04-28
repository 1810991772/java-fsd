package org.example.employee.Employee;

public class Employee {
	public int employeeId;
	private String name;
	private double salary;
	
	public Employee(int employeeId, String name, double salary) {
	
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString()
	{
		return "ID: "+employeeId+" Name: " +name+" Salary: "+salary;
	}
}
