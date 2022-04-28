package org.example.demo;

import org.example.demo.service.OrderService;
import org.example.demo.service.OrderServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

/*
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final Scanner sc = new Scanner(System.in);
        try {
            int choice = 0;
            OrderService orderService = new OrderServiceImpl();

            do {
                System.out.println("1. Create Order.");
                System.out.println("2. Get all orders.");
                System.out.println("3. Get order by ID.");
                System.out.println("4. Delete order by ID.");
                System.out.println("5. Update order by ID.");
                System.out.println("6. Get Order by Item Name.");
                System.out.println("0. Exit");
                System.out.println();
                System.out.print("Enter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        OrderEntity orderEntity = new OrderEntity();
                        System.out.println("Enter order Name: ");
                        orderEntity.setOrderName(sc.next());
                        orderService.createOrder(orderEntity);
                        break;

                    case 2:
                        List<OrderEntity> list = orderService.getAllOrders();
                        for(OrderEntity o : list) {
                            System.out.println(o);
                        }
                        break;

                    case 3:
                        System.out.println("Enter Order ID to be Fetched: ");
                        OrderEntity o1 = orderService.findOrderById(sc.nextInt());

                        if(o1 == null) {
                            System.out.println("No such Order found...");
                        }
                        else {
                            System.out.println("Order Found:- " + o1);
                        }
                        break;

                    case 4:
                        System.out.println("Enter Order ID to be Deleted: ");
                        int id1 = sc.nextInt();
                        OrderEntity or = orderService.findOrderById(id1);
                        if(or == null) {
                            System.out.println("No such Order found...");
                        }
                        else {
                            orderService.deleteOrderById(id1);
                        }
                        break;

                    case 5:
                        System.out.println("Enter Order ID to be Updated: ");
                        int id = sc.nextInt();
                        OrderEntity o2 = orderService.findOrderById(id);
                        if(o2 == null) {
                            System.out.println("No such Order found...");
                        }
                        else {
                            System.out.println("Enter new order Name: ");
                            String name = sc.next();
                            OrderEntity o3 = orderService.updateOrderById(id, name);
                            System.out.println("Order Updated Successfully...");
                        }
                        break;

                    case 6:
                   /*     System.out.println("Enter Item Name: ");
                        String name = sc.next();
                        OrderEntity o6 = orderService.findOrderByItemName(name);
                        System.out.println("Order Found:- " + o6);
//                        if(o6 == null) {
//                            System.out.println("No such Order found...");
//                        }
//                        else {
//                            System.out.println("Order Found:- " + o6);
//                        }
 * */
                    	System.out.println("Under Progress");
 
                        break;

                    case 0:
                        System.out.println("Leaving...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                        break;
                }

            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
