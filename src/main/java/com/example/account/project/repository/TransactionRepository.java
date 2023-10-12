package com.example.account.project.repository;

import com.example.account.project.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.account.number=:number")
    List<Transaction> findAllByAccountNumber(@Param("number") String accountNumber);
}
