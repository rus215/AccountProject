package com.example.account.project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequestDto {
    private String accountNumber;
    private BigDecimal sum;
    private Operation type;
}
