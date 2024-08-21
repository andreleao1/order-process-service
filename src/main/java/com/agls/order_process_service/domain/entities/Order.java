package com.agls.order_process_service.domain.entities;

import com.agls.order_process_service.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document("orders")
public class Order {

    @Id
    private String id;

    private String tradeId;

    private BigDecimal bitcoinValue;

    private BigDecimal dollarAmount;

    private BigDecimal effectiveBitcoinPurchased;

    private OrderStatus status;
}
