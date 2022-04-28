package org.example.demo.service;

import java.util.List;

import org.example.demo.OrderEntity;
import org.example.demo.dao.OrderRepository;
import org.example.demo.dao.OrderRepositoryImpl;

public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepository;
	

	public OrderServiceImpl() {
		super();
		orderRepository=new OrderRepositoryImpl();
	}

	@Override
	public void createOrder(OrderEntity orderEntity) {
		orderRepository.createOrder(orderEntity);
		
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.getAllOrders();
	}

	@Override
	public OrderEntity findOrderById(int id) {
		// TODO Auto-generated method stub
		return orderRepository.findOrderById(id);
	}

	@Override
	public void updateOrderByOrderId(int id) {
		orderRepository.updateOrderByOrderId(id);
		
	}

	@Override
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		orderRepository.deleteOrderById(id);
		
	}

}
