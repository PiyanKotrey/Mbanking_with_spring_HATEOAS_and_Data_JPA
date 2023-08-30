package com.example.mobile_banking_with_spring_hateoas.api.user.web;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.user.User;
import com.example.mobile_banking_with_spring_hateoas.api.user.UserRepository;
import com.example.mobile_banking_with_spring_hateoas.api.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    @GetMapping
    public CollectionModel<?> findAllUser(){
        return userService.findUsers();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findByUuid(@PathVariable String uuid){
        return userService.findUserByUUID(uuid);
    }

    @PostMapping("/createNewUser")
    public EntityModel<?> createNewUser(@RequestBody CreateUserDto createUserDto){
        return userService.createNewUser(createUserDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteUserByUuid(@PathVariable String uuid){
        userService.deletedUserByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    public EntityModel<?> updateUserByUuid(@PathVariable String uuid,@RequestBody UpdateUserDto updateUserDto){
        return userService.updateUserByUuid(uuid,updateUserDto);
    }

    @PutMapping("/{uuid}/disable")
    public ResponseEntity<?> disableUser(@PathVariable String uuid){
        String result = userService.disableUserByUuid(uuid);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{uuid}/accounts")
    public ResponseEntity<List<Account>> getUserAccounts(@PathVariable String uuid) {
        List<Account> accounts = userService.getUserAccountsByUuid(uuid);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/{userUuid}/accounts/{accountUuid}")
    public ResponseEntity<Account> getAccountByUserAndAccountUuid(
            @PathVariable String userUuid,
            @PathVariable String accountUuid) {

        Account account = userService.getAccountByUserUuidAndAccountUuid(userUuid, accountUuid);
        return ResponseEntity.ok(account);
    }

}
