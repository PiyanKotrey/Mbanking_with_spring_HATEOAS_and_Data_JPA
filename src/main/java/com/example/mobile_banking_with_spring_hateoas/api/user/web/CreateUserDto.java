package com.example.mobile_banking_with_spring_hateoas.api.user.web;

import lombok.Builder;

@Builder
public record CreateUserDto(
                            String name,
                            String gender,
                            String email,
                            String uuid,
                            String studentCardNo,
                            String phoneNumber,
                            Boolean isStudent
                            ) {
}
