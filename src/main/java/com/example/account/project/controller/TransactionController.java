package com.example.account.project.controller;

import com.example.account.project.dto.AccountDto;
import com.example.account.project.dto.TransactionDto;
import com.example.account.project.dto.TransactionRequestDto;
import com.example.account.project.dto.TransferDto;
import com.example.account.project.service.TransactionService;
import com.example.account.project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@RequestMapping("/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;
    private final TransferService transferService;

    @GetMapping("/get-info")
    public ResponseEntity<TransactionDto> getInfo(@RequestParam Long id) {
        TransactionDto info = transactionService.getInfo(id);
        return nonNull(info) ? ResponseEntity.ok(info) : ResponseEntity.noContent().build();
    }

    @PostMapping("/get-all")
    public ResponseEntity<List<TransactionDto>> getAll(@RequestBody AccountDto accountDto) {
        List<TransactionDto> transactions = transactionService.getAll(accountDto.getNumber());
        return transactions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transactions);
    }

    @PostMapping("/apply-transaction")
    public ResponseEntity<Void> transaction(@RequestBody TransactionRequestDto requestDto) {
        transactionService.applyTransaction(requestDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransferDto requestDto) {
        transferService.transfer(requestDto);
        return ResponseEntity.noContent().build();
    }
}
