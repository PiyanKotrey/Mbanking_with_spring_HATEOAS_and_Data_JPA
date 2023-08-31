package com.example.mobile_banking_with_spring_hateoas.api.account;

import com.example.mobile_banking_with_spring_hateoas.api.account_type.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String actName;
    private String actNo;
    private String pin;
    private BigDecimal transferLimit;
    private BigDecimal balance;
    private Boolean isStatus;
    @ManyToOne
    private AccountType accountType;
}
