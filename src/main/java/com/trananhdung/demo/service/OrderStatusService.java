package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.OrderStatus;

public interface OrderStatusService {
    OrderStatus addOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatusById(UUID orderStatusId);

    List<OrderStatus> getAllOrderStatuses();

    OrderStatus updateOrderStatus(UUID orderStatusId, OrderStatus updatedOrderStatus);

    void deleteOrderStatus(UUID orderStatusId);
}
