package org.example.demo.service;

import org.example.demo.OrderEntity;
import org.example.demo.dao.OrderRepository;
import org.example.demo.dao.OrderRepositoryImpl;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderServiceImpl() {
        super();
        orderRepository = new OrderRepositoryImpl();
    }

    @Override
    public void createOrder(OrderEntity orderEntity) {

        orderRepository.createOrder(orderEntity);

    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public OrderEntity findOrderById(int id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public OrderEntity updateOrderById(int id, String name) {
        return orderRepository.updateOrderById(id, name);
    }

    @Override
    public OrderEntity findOrderByItemName(String name) {
        return orderRepository.findOrderByItemName(name);
    }
}
