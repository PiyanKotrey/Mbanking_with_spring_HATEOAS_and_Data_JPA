package com.example.mobile_banking_with_spring_hateoas.api.account_type;

import com.example.mobile_banking_with_spring_hateoas.api.account.Account;
import com.example.mobile_banking_with_spring_hateoas.api.account.AccountMapper;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.CreateAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImp implements AccountTypeService{
    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeAssembler accountTypeAssembler;
    @Override
    public CollectionModel<?> findAllAccountType() {
        List<AccountType> accountTypes=accountTypeRepository.findAll();
        return accountTypeAssembler.toCollectionModel(accountTypes);
    }

    @Override
    public EntityModel<?> findById(Long id) {
        AccountType accountType=accountTypeRepository.findById(id).orElseThrow();
        return accountTypeAssembler.toModel(accountType);
    }


}
