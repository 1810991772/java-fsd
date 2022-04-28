package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.OrderEntity;

public interface OrderService {
	
	public OrderEntity createOrder(OrderEntity orderEntity);
	
	public Iterable<OrderEntity> getAllOrders();
	public Optional<OrderEntity> findById(String id);

	public Optional<OrderEntity> findByName(String name);

	public Object updateOrderByOrderId(String orderId, OrderEntity orderEntity);

	public void deleteOrderByOrderId(String orderId);

}
