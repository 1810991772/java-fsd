package org.example.employee;

public abstract class EmployeeFactory {
	public int employeeId;
	public String employeeName;
	public double employeeSalary;
	public abstract void createEmployee(int id,String name,double salary);
	public abstract void findEmployeeById(int id);
	public abstract void displayAllEmployees();
	
}
