package com.example.account.project.mapper;

import com.example.account.project.dto.TransactionDto;
import com.example.account.project.entity.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface TransactionMapper {

    TransactionDto toWeb(Transaction transaction);

    List<TransactionDto> toWeb(List<Transaction> transaction);
}
