package com.example.ExceptionHandling;

public class Employee {

	
	 private int employeeid;
	    private String firstName;
	    private String lastName;
	    private String email;
	    public Employee() {
	        super();
	    }
	    public Employee(int employeeid, String firstName, String lastName, String email) {
	        super();
	        this.employeeid = employeeid;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	    }
	    public int getEmployeeid() {
	        return employeeid;
	    }
	    public void setEmployeeid(int employeeid) {
	        this.employeeid = employeeid;
	    }
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    @Override
	    public String toString() {
	        return "Employee [employeeid=" + employeeid + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
	                + email + "]";
	    }
	    
}
