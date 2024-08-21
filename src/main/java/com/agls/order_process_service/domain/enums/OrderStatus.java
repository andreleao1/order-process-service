package com.agls.order_process_service.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    OPEN("OPEN"),
    EXECUTED("EXECUTED"),
    CANCELLED("CANCELLED");

    private String status;
}
