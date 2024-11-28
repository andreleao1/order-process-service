package com.agls.order_process_service.infra.repository;

import com.agls.order_process_service.domain.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
