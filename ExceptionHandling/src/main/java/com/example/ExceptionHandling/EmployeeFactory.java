package com.example.ExceptionHandling;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
public class EmployeeFactory extends Employee{
	 private Map<Integer, Employee> employeeMap;
	    private static Scanner scanner=new Scanner(System.in);
	    public EmployeeFactory() {
	        employeeMap = new HashMap<Integer, Employee>();
	    }

	 

	    
	    public void createEmployee() throws NumberFormatException,InputMismatchException{
	        int employeeId; 
	        String firstName;
	        String lastName;
	        String email;
	        int count=1;
	        System.out.print("Enter Employee ID: ");
	        employeeId=scanner.nextInt();
	        System.out.print("Enter First Name: ");
	        firstName=scanner.next();
	        System.out.print("Enter Last Name: ");
	        lastName=scanner.next();
	        System.out.print("Enter email: ");
	        email=scanner.next();
	        employeeMap.put(count++, new Employee(employeeId, firstName, lastName, email));
	        System.out.println("Employee Created Sucessfully...");
	        System.out.println(employeeMap);
}
	    
	    public Collection<Employee> getAllAvailableEmployees() throws EmployeeDatabaseEmptyException{
			// TODO Auto-generated method stub
			Collection<Employee> c=employeeMap.values();
			if(c.isEmpty())
			{
				throw new EmployeeDatabaseEmptyException("no employees are available try add some employees and come back here.");
			}
			return c;
		}
	    public void findById(int id) throws EmployeeIdException{
	    	Collection<Entry<Integer, Employee>> c=employeeMap.entrySet();
	    	int count=0;
	    	for(Map.Entry<Integer,Employee> entry: c) {
	    		if(entry.getKey()==id) {
	    			System.out.println("Id founded !!");
	    		}
	    		else {
	    			count++;
	    		}
	    	}
	    	if(count==c.size()) {
	    		throw new EmployeeIdException("no employee of such id is present !!");	    	}
	    }
}
