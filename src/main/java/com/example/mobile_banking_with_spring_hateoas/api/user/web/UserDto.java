package com.example.mobile_banking_with_spring_hateoas.api.user.web;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

import java.util.UUID;

@Builder
@Relation(collectionRelation = "users",itemRelation = "user")
public record UserDto(Long id,
                      String uuid,
                      String name,
                      String gender,
                      String studentCardNo,
                      String phoneNumber,
                      Boolean isStudent) {
}
