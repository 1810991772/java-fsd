package org.example.demo;

import java.util.List;

import org.example.demo.service.OrderService;
import org.example.demo.service.OrderServiceImpl;

public class App {
	public static void main(String[] args) {
		try {
			OrderService orderService = new OrderServiceImpl();
			
			 orderService.createOrder(new OrderEntity("Pen")); List<OrderEntity>
		
			  list=orderService.getAllOrders(); for(OrderEntity e:list) {
			  System.out.println(e); }
			  /*
			 * 
			 * OrderEntity orderEntity=orderService.findOrderById(3); if(orderEntity==null)
			 * { System.out.println("order not found"); } else {
			 * System.out.println(orderEntity); }
			 */
		//	orderService.updateOrderByOrderId(3);
			//orderService.deleteOrderById(3);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
