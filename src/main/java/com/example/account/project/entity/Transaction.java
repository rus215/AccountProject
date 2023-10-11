package com.example.account.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @NotNull
    private BigDecimal sum;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @ManyToOne
    private Account account;
}
