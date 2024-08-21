package com.agls.order_process_service.domain.service.impl;

import com.agls.order_process_service.domain.dto.BitcoinTradeOrderDTO;
import com.agls.order_process_service.domain.models.BitcoinOrderModel;
import com.agls.order_process_service.domain.service.OrderTradingTopicListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderTradingTopicListenerImpl implements OrderTradingTopicListener {
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "order-trading-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        log.info("Received message: " + message);
        try {
            BitcoinOrderModel bitcoinOrderModel = objectMapper.readValue(message, BitcoinOrderModel.class);
            log.info("Processed message: " + bitcoinOrderModel);
        } catch (Exception e) {
            log.error("Error processing message: " + message, e);
        }
    }
}