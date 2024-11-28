package com.agls.order_process_service.domain.service;

public interface OrderTradingTopicListener {

    void listen(String bitcoinOrderModel);
}
