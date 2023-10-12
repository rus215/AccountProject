package com.example.account.project.service;

import com.example.account.project.dto.TransactionDto;
import com.example.account.project.dto.TransactionRequestDto;

import java.util.List;

public interface TransactionService {

    TransactionDto getInfo(Long id);

    List<TransactionDto> getAll(String accountNumber);

    void applyTransaction(TransactionRequestDto requestDto);
}
