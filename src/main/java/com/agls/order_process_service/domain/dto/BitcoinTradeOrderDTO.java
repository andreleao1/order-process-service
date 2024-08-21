package com.agls.order_process_service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BitcoinTradeOrderDTO {
    private String tradeId;
    private String bitcoinValue;
    private String dollarAmount;
    private String effectiveBitcoinPurchased;
}