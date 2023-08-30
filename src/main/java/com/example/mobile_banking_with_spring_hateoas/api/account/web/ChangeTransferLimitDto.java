package com.example.mobile_banking_with_spring_hateoas.api.account.web;

import java.math.BigDecimal;

public record ChangeTransferLimitDto(BigDecimal transferLimit) {
}
