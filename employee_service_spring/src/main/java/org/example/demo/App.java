package org.example.demo;

import org.example.demo.config.SpringConfig;
import org.example.demo.model.Employee;
import org.example.demo.service.EmployeeService;
import org.example.demo.service.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

public class App 
{
	private static Scanner sc=new Scanner(System.in);
	private static ApplicationContext context;
    public static void main( String[] args )
    {
    	context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
        try {
            int choice = 0;
            EmployeeService employeeService=context.getBean("employeeService",EmployeeService.class);

            do {
                System.out.println("1. Create Employee.");
                System.out.println("2. Get all Employees.");
                System.out.println("3. Get Employee by ID.");
                System.out.println("4. Get Employee by First Name.");
                System.out.println("5. Update Employee by ID.");
                System.out.println("6. Delete Employee by ID.");
                System.out.println("0. Exit the application.");
                System.out.println();
                System.out.print("Enter Your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                      
                        System.out.print("Enter first name: "); 
                        String fname=sc.next();
                        System.out.print("Enter last name: "); 
                        String lname=sc.next();
                        System.out.print("Enter email: ");
                        String email=sc.next();
                        Employee employee=new Employee(fname,lname,email);
                        employeeService.createEmployee(employee);
                        break;

                    case 2:
                        Collection<Employee> collection = employeeService.getAllEmployees();
                        for (Employee e : collection) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to be fetched: ");
                        Employee e1 = employeeService.findEmployeeById(sc.nextInt()); System.out.println();
                        if(e1 == null) {
                            System.out.println("Employee not found...");
                        } else {
                            System.out.println("Employee found: " + e1);
                        }
                        break;

                    case 4:
                        System.out.print("Enter first name: ");
                        Employee e2 = employeeService.findEmployeeByFirstName(sc.next()); System.out.println(e2);
                        if(e2 == null) {
                            System.out.println("Employee not found...");
                        } else {
                            System.out.println("Employee found: " + e2);
                        }
                        break;

                    case 5:
                        System.out.print("Enter ID of Employee to be updated: ");
                        int id3 = sc.nextInt(); System.out.println();
                        Employee e3 = employeeService.findEmployeeById(id3);
                        if(e3 == null) {
                            System.out.println("There is no pre-existing Employee with this ID...");
                        } else {
                            System.out.print("Enter First name: ");
                            e3.setFirstName(sc.next());
                            System.out.print("Enter Last name: ");
                            e3.setLastName(sc.next());
                            System.out.print("Enter email: ");
                            e3.setEmail(sc.next());

                            employeeService.updateEmployeeById(e3);
                        }
                        break;

                    case 6:
                        System.out.print("Enter Employee ID to be Deleted: ");
                        int id1 = sc.nextInt();  System.out.println();
                        Employee e = employeeService.findEmployeeById(id1);
                        if(e == null) {
                            System.out.println("No such Employee Found...");
                        } else {
                            employeeService.deleteEmployeeById(id1);
                        }
                        break;

                    case 0:
                        System.out.println("Leaving app...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                        break;

                }

            } while (choice != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
