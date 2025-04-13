package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.Order;

public interface OrderService {
    Order addOrder(Order order);

    Order getOrderById(UUID orderId);

    List<Order> getAllOrders();

    Order updateOrder(UUID orderId, Order updatedOrder);

    void deleteOrder(UUID orderId);
}
