package com.agls.order_process_service.domain.service.impl;

import com.agls.order_process_service.domain.entities.Order;
import com.agls.order_process_service.domain.service.OrderService;
import com.agls.order_process_service.infra.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        log.info("Initiating process to save order: {}", order.getId());

        try {
            orderRepository.save(order);
            log.info("Order saved successfully: {}", order.getId());
        } catch (Exception e) {
            log.error("Error saving order: " + order.getId(), e);
            throw new RuntimeException("Error saving order: " + order.getId(), e);
        }
    }
}
