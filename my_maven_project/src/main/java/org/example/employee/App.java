package org.example.employee;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int ch=0;
		EmployeeFactoryImpl emp=new EmployeeFactoryImpl();
		Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("1. for creating An Array: ");
            System.out.println("2: To Display Our Array: ");
            System.out.println("3: To Search employee in  Array: ");
            System.out.println("0. Exit: ");
            System.out.print("Enter Choice:  ");
            ch=scanner.nextInt();
            switch (ch) {
            case 0:
                System.out.println("Thank u ...!");
                System.exit(0);
            case 1: 
          int id=scanner.nextInt();
          String name=scanner.next();
          double salary=scanner.nextDouble();
          emp.createEmployee(id, name, salary);
                System.out.println("Employee Created");
                break;
            case 2:
                emp.displayAllEmployees();
                break;
            case 3:
            		System.out.print("Enter Eid");
            int id1=scanner.nextInt();
            emp.findEmployeeById(id1);
            break;
            default:
                System.out.println("Wrong Input");
            }
            
        } while (ch!=0);
    
        
	}

}
