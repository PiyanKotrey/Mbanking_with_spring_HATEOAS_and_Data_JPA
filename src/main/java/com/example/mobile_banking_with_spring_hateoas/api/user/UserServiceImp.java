package com.example.mobile_banking_with_spring_hateoas.api.user;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.account.AccountAssembler;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.AccountDto;
import com.example.mobile_banking_with_spring_hateoas.api.user.web.CreateUserDto;
import com.example.mobile_banking_with_spring_hateoas.api.user.web.UpdateUserDto;
import com.example.mobile_banking_with_spring_hateoas.api.user_account.UserAccount;
import com.example.mobile_banking_with_spring_hateoas.api.user_account.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;
    private final UserMapper userMapper;
    private final UserAccountRepository userAccountRepository;
    @Override
    public CollectionModel<?> findUsers() {
        List<User> users = userRepository.findAll();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<?> findUserByUUID(String uuid) {
        User user = userRepository.findUserByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }

    @Override
    public EntityModel<?> createNewUser(CreateUserDto createUserDto) {
        User user = userMapper.mapCreateUserDtoToUser(createUserDto);
        user.setUuid(UUID.randomUUID().toString());
        user.setIsDeleted(false);
        user.setIsVerified(true);
        userRepository.save(user);
        return userModelAssembler.toModel(user);

    }
    @Transactional
    @Override
    public void deletedUserByUuid(String uuid) {
        userRepository.deleteUserByUuid(uuid);
    }

    @Override
    public EntityModel<?> updateUserByUuid(String uuid, UpdateUserDto updateUserDto) {
        Optional<User> optionalUser = userRepository.findUserByUuid(uuid);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
                    user.setName(updateUserDto.name());
                    user.setEmail(updateUserDto.email());
                    user.setPhoneNumber(updateUserDto.phoneNumber());
            userRepository.save(user);
            return userModelAssembler.toModel(user);
        }
        throw new RuntimeException("user with this uuid is not found");
    }
    @Transactional
    @Override
    public String disableUserByUuid(String uuid) {
        Optional<User> optionalUser = userRepository.findUserByUuid(uuid);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setIsDeleted(true);
            userRepository.save(user);
        }
        return "User with UUID " + uuid + " is now disabled.";
    }

    @Override
    public List<Account> getUserAccountsByUuid(String uuid) {
        List<UserAccount> userAccounts = userAccountRepository.findByUserUuid(uuid);
        List<Account> accounts = userAccounts.stream()
                .map(UserAccount::getAccount)
                .collect(Collectors.toList());
        return accounts;
    }

    @Override
    public Account getAccountByUserUuidAndAccountUuid(String userUuid, String accountUuid) {
        User user = userRepository.findUserByUuid(userUuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found for the given UUID"));

        Optional<UserAccount> userAccount = userAccountRepository.findByUser_UuidAndAccount_Uuid(userUuid, accountUuid);

        if (userAccount.isPresent()) {
            return userAccount.get().getAccount();
        } else {
            throw new EntityNotFoundException("Account not found for the given user and account UUIDs.");
        }
    }



}
