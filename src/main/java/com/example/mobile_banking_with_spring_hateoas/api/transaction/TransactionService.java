package com.example.mobile_banking_with_spring_hateoas.api.transaction;

import java.math.BigDecimal;

public interface TransactionService {
    void performTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
