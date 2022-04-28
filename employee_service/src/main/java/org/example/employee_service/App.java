package org.example.employee_service;
/*import java.util.Scanner;

import org.example.employee_service.model.Employee;
import org.example.employee_service.model.EmployeeFactory;
import org.example.employee_service.model.EmployeeFactoryImpl;


public class App 
{
	private static Scanner scanner=new Scanner(System.in);
	public static void main( String[] args )
    {
		
		EmployeeFactory employeeFactory=new EmployeeFactoryImpl();
		int choice=0;
		int id=0;
		String name=null;
		double sal=0.0;
		
		do {
			
			System.out.println("1. Create Employee. ");
			System.out.println("2. Display Employees. ");
			System.out.println("3: Display Employee By Id: ");
			System.out.println("0: Exit ");
			System.out.print("Enter Your Choice: ");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("ID: ");
				id=scanner.nextInt();
				System.out.print("Name: ");
				name=scanner.next();
				System.out.print("Salary: ");
				sal=scanner.nextDouble();
				Employee employee=employeeFactory.createEmployee(id, name, sal);
				System.out.println("Employee Created Sucessfully..."+employee);
				break;
			case 2:
				Employee[] employees=employeeFactory.fetchAllEmployees();
				for(Employee e:employees)
				{
					System.out.println(e);
				}
				break;
			case 3:
				System.out.print("ID: ");
				id=scanner.nextInt();
				employeeFactory.findEmployeeById(id);
				break;
			case 0:
				System.out.println("Bye.");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (choice!=0);
		
        
    }
}
*/
import java.util.Scanner;



import org.example.employee_service.model.Employee;
import org.example.employee_service.model.EmployeeFactoryImpl;

 

public class App {
    private static Scanner scanner = new Scanner(System.in);

 

    public static void main(String[] args) {

 

        EmployeeFactoryImpl employeeFactory = new EmployeeFactoryImpl();
        int choice = 0;
        int id = 0;
        String name = null;
        double sal = 0.0;

 

        do {

 

            System.out.println("1. Create Employee. ");
            System.out.println("2. Display Employees. ");
            System.out.println("3: Display Employee By Id: ");
            System.out.println("0: Exit ");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
            case 1:
                System.out.print("ID: ");
                id = scanner.nextInt();
                System.out.print("Name: ");
                name = scanner.next();
                System.out.print("Salary: ");
                sal = scanner.nextDouble();
                Employee employee = employeeFactory.factory.createEmployee(id, name, sal);
                System.out.println("Employee Created Sucessfully..." + employee);
                break;
            case 2:
                Employee[] employees = employeeFactory.factory.fetchAllEmployees();
                for (Employee e : employees) {
                    System.out.println(e);
                }
                break;
            case 3:
                System.out.print("ID: ");
                id = scanner.nextInt();
                employeeFactory.factory.findEmployeeById(id);
                break;
            case 0:
                System.out.println("Bye.");
                System.exit(0);
            default:
                System.out.println("Invalid Choice");
                break;
            }
        } while (choice != 0);

 

    }
}
 
