package com.example.mobile_banking_with_spring_hateoas.api.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService{
    private final TransactionRepository transactionRepository;
    @Transactional
    @Override
    public void performTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        transactionRepository.transferFunds(fromAccountId, toAccountId, amount);
    }
}
