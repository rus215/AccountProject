package com.example.account.project.dto;

import com.example.account.project.entity.Currency;
import com.example.account.project.entity.TransactionType;
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
