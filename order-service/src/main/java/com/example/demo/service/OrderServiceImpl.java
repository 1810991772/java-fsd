package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.OrderEntity;
import com.example.demo.repo.OrderRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepository;

@Override
public OrderEntity createOrder(OrderEntity orderEntity) {
	// TODO Auto-generated method stub
	return orderRepository.save(orderEntity);
}



@Override
public Optional<OrderEntity> findById(String id) {
	// TODO Auto-generated method stub
	return orderRepository.findByOrderId(id);
}



@Override
public Iterable<OrderEntity> getAllOrders() {
	// TODO Auto-generated method stub
	 List<OrderEntity> orders = new ArrayList<>();
	orderRepository.findAll().forEach(orders::add);;
	 if(orders.isEmpty())
	 {
		 throw new OrderNotFoundException("order  not found Please Place order first");
	 }
	return orderRepository.findAll();
}



@Override
public Optional<OrderEntity> findByName(String name) {
	// TODO Auto-generated method stub
	return orderRepository.findByOrderName(name);
}
@Override
public OrderEntity updateOrderByOrderId(String orderId,OrderEntity orderEntity)
{
	Optional<OrderEntity> order = orderRepository.findByOrderId(orderId);
	if (!order.isPresent()) {
		throw new OrderNotFoundException("order with " + orderId + " not found");
	}
	OrderEntity e = order.get();
	e.setOrderName(orderEntity.getOrderName());
	e.setOrderValue(orderEntity.getOrderValue());
	e.setCustomerDetails(orderEntity.getCustomerDetails());

	return orderRepository.save(e);
}
@Override
public void deleteOrderByOrderId(String orderId) 
{
	Optional<OrderEntity> order = orderRepository.findByOrderId(orderId);
	if (!order.isPresent()) {
		throw new OrderNotFoundException("order with " + orderId + " not found");
	}
	orderRepository.delete(order.get());
}



}
