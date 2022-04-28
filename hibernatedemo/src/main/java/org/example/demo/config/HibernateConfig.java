package org.example.demo.config;

import org.example.demo.OrderEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	
	private static SessionFactory sessionFactory;
	
	{
		
	}
	
	
	public static SessionFactory getSessionFactory()
	{
		sessionFactory=new Configuration().configure().addAnnotatedClass(OrderEntity.class).buildSessionFactory();
		return sessionFactory;
	}

}
