package com.example.account.project.service;

import com.example.account.project.dto.TransactionRequestDto;
import com.example.account.project.dto.TransactionType;
import com.example.account.project.dto.TransferDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService {

    private final TransactionService service;

    @Transactional
    @Override
    public void transfer(TransferDto requestDto) {
        TransactionRequestDto transact1 = new TransactionRequestDto();
        transact1.setSum(requestDto.getSum());
        transact1.setType(TransactionType.WRITE_OFF);
        transact1.setAccountNumber(requestDto.getFromAccountNumber());
        service.applyTransaction(transact1);

        TransactionRequestDto transact2 = new TransactionRequestDto();
        transact2.setSum(requestDto.getSum());
        transact2.setType(TransactionType.REFILL);
        transact2.setAccountNumber(requestDto.getToAccountNumber());
        service.applyTransaction(transact2);
    }
}
