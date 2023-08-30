package com.example.mobile_banking_with_spring_hateoas.api.user_role;

import com.example.mobile_banking_with_spring_hateoas.api.role.Role;
import com.example.mobile_banking_with_spring_hateoas.api.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    private Role role;
    @ManyToOne
    private User user;
}
