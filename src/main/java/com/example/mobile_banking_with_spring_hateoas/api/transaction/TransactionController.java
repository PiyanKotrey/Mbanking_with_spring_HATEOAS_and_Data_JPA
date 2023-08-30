package com.example.mobile_banking_with_spring_hateoas.api.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/transfer")
public class TransactionController {
    private final TransactionService transactionService;

    @Transactional
    @PostMapping
    public ResponseEntity<String> transferFunds(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam BigDecimal amount) {
        transactionService.performTransaction(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("*Sender from account id:"+fromAccountId
                +" *Receiver from account id:"+toAccountId+" *amount is:"+amount);
    }
}
