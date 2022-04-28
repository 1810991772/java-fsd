package org.example.employee;
import org.example.employee.Employee.*;

import java.util.Arrays;

public class EmployeeFactoryImpl extends EmployeeFactory{
 Employee[] employees=new Employee[1];
	@Override
	public void createEmployee(int id, String name, double salary) {
		// TODO Auto-generated method stub
		int i=0;
		employees[i]=new Employee(id,name,salary);
		i++;
	
	}
	@Override
	public void findEmployeeById(int id) {
		// TODO Auto-generated method stub
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i].employeeId==id)
			{
			System.out.println(employees[i].toString());	
			}
		}
		System.out.println("invalid id");
		
	}

	@Override
	public void displayAllEmployees() {
		// TODO Auto-generated method stub
		for(int i=0;i<employees.length;i++)
		{
			System.out.println(employees[i].toString());
		}
	
	}
	
}

