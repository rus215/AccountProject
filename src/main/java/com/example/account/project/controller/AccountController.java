package com.example.account.project.controller;

import com.example.account.project.dto.BalanceDto;
import com.example.account.project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    @PostMapping("/balance")
    public BalanceDto getBalance(@RequestBody BalanceDto balance) {
        return service.getAccountBalance(balance.getNumber());
    }
}
