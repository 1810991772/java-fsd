package org.example.demo.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.example.demo.OrderEntity;
import org.example.demo.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OrderRepositoryImpl implements OrderRepository {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Scanner scanner=new Scanner(System.in);

	public OrderRepositoryImpl() {
	
		super();
		sessionFactory=HibernateConfig.getSessionFactory();
		session=sessionFactory.openSession();
	}

	@Override
	public void createOrder(OrderEntity orderEntity) {
		
		session.getTransaction().begin();
		session.save(orderEntity);
		session.getTransaction().commit();
		System.out.println("order created. sucessfully..");

	}

	@Override
	
	public List<OrderEntity> getAllOrders() {
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		TypedQuery<OrderEntity> query=session.createQuery("FROM OrderEntity",OrderEntity.class);
		session.getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public OrderEntity findOrderById(int id) {
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		OrderEntity orderEntity=session.get(OrderEntity.class, id);
		session.getTransaction().commit();
		return orderEntity;
	}

	@Override
	public void updateOrderByOrderId(int id) {
		OrderEntity orderEntity=findOrderById(id);
		if(orderEntity==null)
		{
			System.out.println("order not found.");
		}
		else
		{
			System.out.println("Order Found...");
			System.out.print("Enter New Order Name: ");
			String name=scanner.next();
			orderEntity.setOrderName(name);
			session.getTransaction().begin();
			session.merge(orderEntity);
			session.getTransaction().commit();
			System.out.println("Updated sucessfully..");
		}
		
	}

	@Override
	public void deleteOrderById(int id) {
		OrderEntity orderEntity=findOrderById(id);
		if(orderEntity==null)
		{
			System.out.println("order Not Found.");
		}
		else
		{
			session.getTransaction().begin();
			session.remove(orderEntity);
			session.getTransaction().commit();
			System.out.println("deletion sucessed.");
		}
		
	}

}
