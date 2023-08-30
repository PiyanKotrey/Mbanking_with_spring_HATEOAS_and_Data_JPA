package com.example.mobile_banking_with_spring_hateoas.api.user.web;

import lombok.Builder;

@Builder
public record UpdateUserDto(String name,
                            String email,
                            String phoneNumber
                            ) {
}
