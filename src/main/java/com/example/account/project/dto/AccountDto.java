package com.example.account.project.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AccountDto {
    private Long id;

    private String number;

    private BigDecimal sum;

    private Currency currency;

    private List<TransactionDto> transactions;
}
