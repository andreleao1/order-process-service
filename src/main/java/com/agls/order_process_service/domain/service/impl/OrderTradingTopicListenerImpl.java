package com.agls.order_process_service.domain.service.impl;

import com.agls.order_process_service.domain.dto.BitcoinTradeOrderDTO;
import com.agls.order_process_service.domain.entities.Order;
import com.agls.order_process_service.domain.enums.OrderStatus;
import com.agls.order_process_service.domain.service.OrderService;
import com.agls.order_process_service.domain.service.OrderTradingTopicListener;
import com.agls.order_process_service.infra.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderTradingTopicListenerImpl implements OrderTradingTopicListener {

    private final ObjectMapper objectMapper;

    private final OrderService orderService;

    @KafkaListener(topics = "order-trading-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        var bitcoinOrderModel = processMessage(message);

        try {
            var newOrder = objectMapper.convertValue(bitcoinOrderModel, Order.class);
            log.info("Order created: {}", newOrder.getId());

            orderService.saveOrder(newOrder);
        } catch (Exception e) {
            log.error("Error to process trade: {}", bitcoinOrderModel.getTradeId());
            throw new RuntimeException("Error saving order: " + bitcoinOrderModel, e);
        }
    }

    private BitcoinTradeOrderDTO processMessage(String jsonMessage) {
        try {
            var processedMessage =  objectMapper.readValue(jsonMessage, BitcoinTradeOrderDTO.class);
            log.info("Trade {} processed successfully: ", processedMessage.getTradeId());

            return processedMessage;
        } catch (JsonProcessingException e) {
            log.error("Error processing message: " + jsonMessage, e);
            throw new RuntimeException("Error processing message: " + jsonMessage, e);
        }
    }
}