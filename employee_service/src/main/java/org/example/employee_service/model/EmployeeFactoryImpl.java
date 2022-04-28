package org.example.employee_service.model;
/*import java.util.Scanner;

public class EmployeeFactoryImpl implements EmployeeFactory{
	private static Scanner scanner=new Scanner(System.in);
	private Employee[] employees;
	private static int i=0;
	

	public EmployeeFactoryImpl() {
		
		System.out.print("Enter The Sizeof employees array: ");
		employees=new Employee[scanner.nextInt()];
		System.out.println("employees array initialized sucessfully...");
		
	}

	

	@Override
	public Employee createEmployee(int employeeId, String employeeName, double salary) {
		Employee e=new Employee(employeeId, employeeName, salary);
		employees[i]=e;
		
		++i;
		return e; 
	}

	@Override
	public Employee[] fetchAllEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public void findEmployeeById(int employeeId) {
		//enhanched for loop
		boolean flag=false;
		OUTER:
		for(Employee employee:employees)
		{
			if(employee.getEmployeeId()==employeeId)
			{
				System.out.println("Employee Found. "+employee);
				flag=true;
				break OUTER;
			}
			else
			{
				flag=false;
				continue OUTER;
			}
			
		}
		
		if(flag==false)
		{
			System.out.println("employee not found");
		}
}
}*/


import java.util.Scanner;



public class EmployeeFactoryImpl {
   
   private static Scanner scanner=new Scanner(System.in);
   private Employee[] employees;
   private static int i=0;
   public EmployeeFactory factory=new EmployeeFactory() {
       
           @Override
           public Employee createEmployee(int employeeId, String employeeName, double salary) {
               Employee e=new Employee(employeeId, employeeName, salary);
               employees[i]=e;
               
               ++i;
               return e; 
           }



           @Override
           public Employee[] fetchAllEmployees() {
               // TODO Auto-generated method stub
               return employees;
           }



           @Override
           public void findEmployeeById(int employeeId) {
               //enhanched for loop
               boolean flag=false;
               OUTER:
               for(Employee employee:employees)
               {
                   if(employee.getEmployeeId()==employeeId)
                   {
                       System.out.println("Employee Found. "+employee);
                       flag=true;
                       break OUTER;
                   }
                   else
                   {
                       flag=false;
                       continue OUTER;
                   }
                   
               }
               
               if(flag==false)
               {
                   System.out.println("employee not found");
               }
               
           }



   };



   public EmployeeFactoryImpl() {
       
       System.out.print("Enter The Sizeof employees array: ");
       employees=new Employee[scanner.nextInt()];
       System.out.println("employees array initialized sucessfully...");
       
   }



   




}
