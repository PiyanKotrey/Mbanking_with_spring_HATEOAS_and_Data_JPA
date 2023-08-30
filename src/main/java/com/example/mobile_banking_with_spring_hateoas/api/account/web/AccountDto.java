package com.example.mobile_banking_with_spring_hateoas.api.account.web;

import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;
@Relation(collectionRelation = "accounts",itemRelation = "account")
public record AccountDto(String uuid,
                         String actName,
                         String actNo,
                         BigDecimal transferLimit) {
}
