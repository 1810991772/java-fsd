package com.example.ExceptionHandling;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
    	
           /* 
            * try{
            * System.out.println(args.length);
            * 
            * int x = 100 / 0; System.out.println(x);
            *
            * int a = Integer.parseInt(args[0]); System.out.println(a);
            * System.out.println(args[0] + " " + args[1]);
            * 
            * } catch (NumberFormatException | ArrayIndexOutOfBoundsException |
            * ArithmeticException e) { System.err.println("exception happened: " +
            * e.getMessage());
            * 
            * }
            */
           
           EmployeeFactory employeeFactory=new EmployeeFactory();
           int choice=5;
           int id=0;
           Scanner sc =new Scanner(System.in);
           while(choice!=0) {
           System.out.println("Enter the choice: ");
           choice=sc.nextInt();
           
           if(choice==1) {
           
           try {
               employeeFactory.createEmployee();
               
           } catch (Exception e) {
               // TODO: handle exception
               System.err.println("Number Format Exception Occured...");
               continue;
               
           }
           }
           if(choice==2) {
           try {
   			Collection<Employee> employees=employeeFactory.getAllAvailableEmployees();
   			for(Employee e:employees)
   			{
   				System.out.println(e);
   			}
   			
   		    }
           catch (Exception e) {
   			System.err.println(e.getMessage());
   			continue;
   		    }
           }
           if(choice==3) {
        	   System.out.println("Enter the id you want to search : ");
        	   id=sc.nextInt();
        	   try {
        		   employeeFactory.findById(id);
        	   }
        	   catch(Exception e) {
        		   System.err.println(e.getMessage());
        		   continue;
        	   }
        	   
           }
          if(choice==0) {
        	  System.out.println("Time out !!");
          }
          
           }
           }
           
    }

