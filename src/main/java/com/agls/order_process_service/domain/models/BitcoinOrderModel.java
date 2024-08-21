package com.agls.order_process_service.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BitcoinOrderModel {

    private String tradeId;

    private BigDecimal bitcoinValue;

    private BigDecimal dollarAmount;

    private BigDecimal effectiveBitcoinPurchased;
}
