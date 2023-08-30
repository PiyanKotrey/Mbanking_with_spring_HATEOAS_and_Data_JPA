package com.example.mobile_banking_with_spring_hateoas.api.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Modifying
    @Query(value = "CALL transfer_funds(:fromAccountId, :toAccountId, :amount)", nativeQuery = true)
    void transferFunds(
            @Param("fromAccountId") Long fromAccountId,
            @Param("toAccountId") Long toAccountId,
            @Param("amount") BigDecimal amount

    );
}
