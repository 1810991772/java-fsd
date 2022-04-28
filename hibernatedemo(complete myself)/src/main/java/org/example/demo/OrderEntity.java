package org.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "order_table2")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "order_name")
    private String orderName;

    public OrderEntity() {
        super();
    }

    public OrderEntity(String orderName) {
        super();
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName(String orderName) {
        this.orderName = orderName;
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return "OrderEntity [ orderId: " + orderId + ", orderName: " + orderName + " ]";
    }
}
