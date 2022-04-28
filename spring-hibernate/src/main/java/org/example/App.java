package org.example;

import org.example.config.SpringConfig;
import org.example.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
            SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
            org.hibernate.Session session = sessionFactory.openSession();
            Customer customer = new Customer("John", "Doe", "john@doe.com");
            session.getTransaction().begin();
            session.persist(customer);
            session.getTransaction().commit();
            System.out.println("customer created...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
