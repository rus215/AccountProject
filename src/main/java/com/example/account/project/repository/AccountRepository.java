package com.example.account.project.repository;

import com.example.account.project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Account> findAccountForReadByNumber(String number);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Account> findAccountForUpdateByNumber(String number);
}
