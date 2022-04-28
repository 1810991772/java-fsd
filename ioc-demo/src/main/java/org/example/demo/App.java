package org.example.demo;

import org.example.demo.beans.Coach;
import org.example.demo.beans.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
       try {
    	   
    	   context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	   Coach myCoach=context.getBean("theCoach",Coach.class);
    	   System.out.println(myCoach.getDailyWorkOut());
    	   System.out.println(myCoach.getDailyFortune());
    	   
			/*
			 * Employee tempEmployee=context.getBean("employee",Employee.class);
			 * System.out.println(tempEmployee);
			 * 
			 * tempEmployee.setFirstName("Sachin"); tempEmployee.setLastName("tendulkar");
			 * tempEmployee.setEmail("sachin@email.com"); System.out.println(tempEmployee);
			 * Employee tempEmployee1=context.getBean("employee",Employee.class);
			 * System.out.println(tempEmployee1);
			 * 
			 * tempEmployee1.setFirstName("Sachin1");
			 * tempEmployee1.setLastName("tendulkar1");
			 * tempEmployee1.setEmail("sachin1@email.com");
			 * System.out.println(tempEmployee1);
			 * System.out.println(tempEmployee==tempEmployee1);
			 */
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
}
