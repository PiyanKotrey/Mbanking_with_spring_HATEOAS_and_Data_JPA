package com.example.mobile_banking_with_spring_hateoas.api.transaction;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.account_type.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String studentCardNo;
    private String remark;
    private LocalDateTime transactionAt;
    private BigDecimal amount;
    private Boolean isPayment;
    @ManyToOne
    private Account senderActId;
    @ManyToOne
    private Account receiverActId;
}
