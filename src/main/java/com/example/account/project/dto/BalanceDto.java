package com.example.account.project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceDto {
    private String number;
    private BigDecimal balance;
    private Currency currency;
}
