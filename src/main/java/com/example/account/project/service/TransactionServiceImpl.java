package com.example.account.project.service;

import com.example.account.project.dto.TransactionDto;
import com.example.account.project.dto.TransactionRequestDto;
import com.example.account.project.entity.Account;
import com.example.account.project.entity.Currency;
import com.example.account.project.entity.Transaction;
import com.example.account.project.entity.TransactionType;
import com.example.account.project.mapper.TransactionMapper;
import com.example.account.project.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;
    private final AccountService accountService;

    @Transactional(readOnly = true)
    @Override
    public TransactionDto getInfo(Long id) {
        return transactionRepository.findById(id)
                .map(mapper::toWeb).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TransactionDto> getAll(String accountNumber) {
        return mapper.toWeb(transactionRepository.findAllByAccountNumber(accountNumber));
    }

    @Transactional
    @Override
    public void applyTransaction(TransactionRequestDto requestDto) {
        TransactionType type = TransactionType.valueOf(requestDto.getType().name());
        Transaction transaction = new Transaction();
        transaction.setCurrency(Currency.RUB);
        transaction.setSum(requestDto.getSum());
        transaction.setType(type);

        Account account = accountService.recalculateBalance(
                requestDto.getAccountNumber(),
                requestDto.getSum(),
                type
        );
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }
}
