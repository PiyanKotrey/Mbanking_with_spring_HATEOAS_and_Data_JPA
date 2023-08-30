package com.example.mobile_banking_with_spring_hateoas.api.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByUuid(String uuid);
}
