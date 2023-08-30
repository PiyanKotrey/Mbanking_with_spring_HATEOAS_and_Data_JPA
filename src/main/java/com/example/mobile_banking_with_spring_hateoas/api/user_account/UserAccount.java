package com.example.mobile_banking_with_spring_hateoas.api.user_account;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isDisable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    private User user;
    @ManyToOne
    private Account account;
}
