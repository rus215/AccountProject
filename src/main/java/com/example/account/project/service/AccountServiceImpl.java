package com.example.account.project.service;

import com.example.account.project.dto.BalanceDto;
import com.example.account.project.entity.Account;
import com.example.account.project.entity.TransactionType;
import com.example.account.project.mapper.AccountMapper;
import com.example.account.project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    @Transactional
    @Override
    public BalanceDto getAccountBalance(String accountNum) {
        return repository.findAccountForReadByNumber(accountNum)
                .map(mapper::balanceDto).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Account recalculateBalance(String accountNumber, BigDecimal sum, TransactionType type) {
        Account account = repository.findAccountForUpdateByNumber(accountNumber).orElseThrow();
        BigDecimal currentSum = account.getSum();
        if (type == TransactionType.REFILL) {
            account.setSum(currentSum.add(sum));
        } else if (type == TransactionType.WRITE_OFF) {
            account.setSum(currentSum.subtract(sum));
        }
        return repository.save(account);
    }

}
