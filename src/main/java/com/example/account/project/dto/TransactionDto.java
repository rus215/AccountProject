package com.example.account.project.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long id;

    private LocalDateTime dateTime;

    private TransactionType type;

    private BigDecimal sum;

    private Currency currency;

}
