package com.example.mobile_banking_with_spring_hateoas.api.user;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.user_account.UserAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String phoneNumber;
    private String StudentCardNo;
    private String verifiedCode;
    private String oneSignalId;
    private Boolean isStudent;
    private Boolean isDeleted;
    private Boolean isVerified;

    public Account getAccountByUuid(String accountUuid) {
        List<UserAccount> userAccounts = new ArrayList<>();
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.getAccount().getUuid().equals(accountUuid)) {
                return userAccount.getAccount();
            }
        }
        return null;
    }

}
