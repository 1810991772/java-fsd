package org.example.demo;

import org.example.demo.beans.Coach;
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
    	   Coach myWorkout=context.getBean("cricketCoach",Coach.class);
    	  
    	   System.out.println(myWorkout.getDailyWorkOut());
    	   System.out.println(myWorkout.getDailyFortune());
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
    }
}
