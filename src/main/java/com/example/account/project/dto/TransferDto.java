package com.example.account.project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {
    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal sum;
}
