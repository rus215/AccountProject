package com.example.account.project.controller;

import com.example.account.project.dto.AccountDto;
import com.example.account.project.dto.TransactionDto;
import com.example.account.project.dto.TransactionRequestDto;
import com.example.account.project.entity.TransactionType;
import com.example.account.project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/transaction")
@RestController
public class TransactionController {

    private final TransactionService service;

    @GetMapping("/get-info")
    public TransactionDto getInfo(@RequestParam Long id) {
        return service.getInfo(id);
    }

    @PostMapping("/get-all")
    public List<TransactionDto> getAll(@RequestBody AccountDto accountDto) {
        return service.getAll(accountDto.getNumber());
    }

    @PostMapping("/apply-transaction")
    public ResponseEntity<Void> transaction(@RequestBody TransactionRequestDto requestDto) {
        service.applyTransaction(requestDto);
        return ResponseEntity.noContent().build();
    }
}
