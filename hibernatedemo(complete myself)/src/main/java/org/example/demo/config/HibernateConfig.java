package org.example.demo.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        sessionFactory = new Configuration().configure().addAnnotatedClass(Order.class).buildSessionFactory();
        return sessionFactory;
    }
}
