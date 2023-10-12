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

@RequiredArgsConstructor
@RequestMapping("/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;
    private final TransferService transferService;

    @GetMapping("/get-info")
    public TransactionDto getInfo(@RequestParam Long id) {
        return transactionService.getInfo(id);
    }

    @PostMapping("/get-all")
    public List<TransactionDto> getAll(@RequestBody AccountDto accountDto) {
        return transactionService.getAll(accountDto.getNumber());
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
