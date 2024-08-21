package com.agls.order_process_service.domain.service;

import com.agls.order_process_service.domain.dto.BitcoinTradeOrderDTO;
import com.agls.order_process_service.domain.models.BitcoinOrderModel;

public interface OrderTradingTopicListener {

    void listen(String bitcoinOrderModel);
}
