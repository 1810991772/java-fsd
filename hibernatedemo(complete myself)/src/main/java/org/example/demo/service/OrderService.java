package org.example.demo.service;

import org.example.demo.OrderEntity;

import java.util.List;

public interface OrderService {

    public void createOrder(OrderEntity orderEntity);
    public List<OrderEntity> getAllOrders();
    public OrderEntity findOrderById(int id);
    public void deleteOrderById(int id);
    public OrderEntity updateOrderById(int id, String name);
    public OrderEntity findOrderByItemName(String name);
}
