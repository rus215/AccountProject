package com.example.account.project.mapper;

import com.example.account.project.dto.BalanceDto;
import com.example.account.project.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface AccountMapper {

    @Mapping(target = "balance", source = "sum")
    BalanceDto balanceDto(Account account);
}
