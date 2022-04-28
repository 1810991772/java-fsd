package org.example.demo.service;

import java.util.List;

import org.example.demo.OrderEntity;

public interface OrderService {
	public void createOrder(OrderEntity orderEntity);

	public List<OrderEntity> getAllOrders();

	public OrderEntity findOrderById(int id);

	public void updateOrderByOrderId(int id);

	public void deleteOrderById(int id);

}
