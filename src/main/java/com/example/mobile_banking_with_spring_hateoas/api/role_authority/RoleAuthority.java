package com.example.mobile_banking_with_spring_hateoas.api.role_authority;

import com.example.mobile_banking_with_spring_hateoas.api.authority.Authority;
import com.example.mobile_banking_with_spring_hateoas.api.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles_authorities")
public class RoleAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    private Role roles;
    @ManyToOne
    private Authority authorities;
}
