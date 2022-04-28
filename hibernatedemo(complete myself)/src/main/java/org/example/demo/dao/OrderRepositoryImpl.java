package org.example.demo.dao;

import org.example.demo.OrderEntity;
import org.example.demo.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public OrderRepositoryImpl() {

        super();
        sessionFactory = HibernateConfig.getSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public void createOrder(OrderEntity orderEntity) {

        session.getTransaction().begin();
        session.save(orderEntity);
        session.getTransaction().commit();

        System.out.println("Order created successfully...");
    }

    @Override
    public List<OrderEntity> getAllOrders() {

        session = sessionFactory.openSession();
        session.getTransaction().begin();
        TypedQuery<OrderEntity> query = session.createQuery("FROM OrderEntity", OrderEntity.class);
        session.getTransaction().commit();

        return query.getResultList();
    }

    @Override
    public OrderEntity findOrderById(int id) {

        session = sessionFactory.openSession();
        session.getTransaction().begin();
        OrderEntity orderEntity = session.get(OrderEntity.class, id);
        session.getTransaction().commit();

        return orderEntity;
    }

    @Override
    public void deleteOrderById(int id) {

        session = sessionFactory.openSession();
        session.getTransaction().begin();
        OrderEntity o = (OrderEntity) session.get(OrderEntity.class, id);
        session.delete(o);
        session.getTransaction().commit();
        System.out.println("Order No. " + id + " deleted successfully..." );
    }

    @Override
    public OrderEntity updateOrderById(int id, String name) {

        session = sessionFactory.openSession();
        session.getTransaction().begin();
        OrderEntity o = (OrderEntity) session.get(OrderEntity.class, id);
        o.setOrderName(name);
        session.update(o);
        session.getTransaction().commit();

        return o;
    }

    @Override
    public OrderEntity findOrderByItemName(String name) {

        session = sessionFactory.openSession();
        session.getTransaction().begin();
        OrderEntity orderEntity = session.get(OrderEntity.class, name);
        session.getTransaction().commit();

        return orderEntity;
    }
}
