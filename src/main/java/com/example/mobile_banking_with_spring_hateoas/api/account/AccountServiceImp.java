package com.example.mobile_banking_with_spring_hateoas.api.account;

import com.example.mobile_banking_with_spring_hateoas.api.account.web.ChangeTransferLimitDto;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.CreateAccountDto;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.RenameDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountAssembler accountAssembler;
    private final AccountMapper accountMapper;
    @Override
    public CollectionModel<?> findAllAccount() {
        List<Account> accounts=accountRepository.findAll();
        return accountAssembler.toCollectionModel(accounts);
    }

    @Override
    public EntityModel<?> findAccountByUuid(String uuid) {
        Account account = accountRepository.findAccountByUuid(uuid).orElseThrow();
        return accountAssembler.toModel(account);
    }

    @Override
    public EntityModel<?> createNewAccount(CreateAccountDto createAccountDto) {
        Account account = accountMapper.mapCreateAccountDtoToAccount(createAccountDto);
        account.setUuid(UUID.randomUUID().toString());
        accountRepository.save(account);
        return accountAssembler.toModel(account);
    }

    @Override
    public EntityModel<?> renameAccountByUuid(String uuid, RenameDto renameDto) {
        Optional<Account> optionalAccount = accountRepository.findAccountByUuid(uuid);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setActName(renameDto.actName());
            accountRepository.save(account);
            return accountAssembler.toModel(account);
        }
        throw new RuntimeException("Not fond with this uuid");
    }

    @Override
    public EntityModel<?> changeTransferLimitByUuid
            (String uuid, ChangeTransferLimitDto changeTransferLimitDto) {
        Optional<Account> optionalAccount = accountRepository.findAccountByUuid(uuid);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setTransferLimit(changeTransferLimitDto.transferLimit());
            accountRepository.save(account);
            return accountAssembler.toModel(account);
        }
        throw new RuntimeException("Not Found with this uuid");
    }
    @Transactional
    @Override
    public String closedAccByUuid(String uuid) {
        Optional<Account> optionalAccount = accountRepository.findAccountByUuid(uuid);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setIsStatus(false);
            accountRepository.save(account);
        }
        return "Account with UUID " + uuid + " is now disabled.";
    }
}
