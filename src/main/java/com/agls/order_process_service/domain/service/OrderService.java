package com.agls.order_process_service.domain.service;

import com.agls.order_process_service.domain.entities.Order;

public interface OrderService {

    void saveOrder(Order order);
}
