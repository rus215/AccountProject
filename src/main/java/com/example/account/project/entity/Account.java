package com.example.account.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotNull
    private String number;

    private BigDecimal sum;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
