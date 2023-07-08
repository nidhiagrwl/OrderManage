package org.example.service;

import org.example.dto.OrderDto;
import org.example.view.OrderView;

public interface OrderService {

    OrderView createOrder(OrderDto order) throws Exception;

    OrderView updateOrder(OrderDto order) throws Exception;

    void deleteOrder(String orderId) throws Exception;

    OrderView getOrders(String orderId) throws Exception;
}
