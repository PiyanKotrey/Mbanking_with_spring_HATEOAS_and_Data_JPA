package com.example.mobile_banking_with_spring_hateoas.api.user;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.user.web.CreateUserDto;
import com.example.mobile_banking_with_spring_hateoas.api.user.web.UpdateUserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    CollectionModel<?> findUsers();
    EntityModel<?> findUserByUUID(String uuid);
    EntityModel<?> createNewUser(CreateUserDto createUserDto);
    void deletedUserByUuid(String uuid);
    EntityModel<?> updateUserByUuid(String uuid, UpdateUserDto updateUserDto);
    String disableUserByUuid(String uuid);
    List<Account> getUserAccountsByUuid(String uuid);
    Account getAccountByUserUuidAndAccountUuid(String userUuid, String AccountUuid);

}
