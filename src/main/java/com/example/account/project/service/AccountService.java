package com.example.account.project.service;

import com.example.account.project.dto.BalanceDto;
import com.example.account.project.entity.Account;
import com.example.account.project.entity.TransactionType;

import java.math.BigDecimal;

public interface AccountService {

    BalanceDto getAccountBalance(String accountNum);

    Account recalculateBalance(String accountNumber, BigDecimal sum, TransactionType type);
}
