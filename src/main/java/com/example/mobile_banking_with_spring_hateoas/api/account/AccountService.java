package com.example.mobile_banking_with_spring_hateoas.api.account;

import com.example.mobile_banking_with_spring_hateoas.api.account.web.ChangeTransferLimitDto;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.CreateAccountDto;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.RenameDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    CollectionModel<?> findAllAccount();
    EntityModel<?> findAccountByUuid(String uuid);
    EntityModel<?> createNewAccount(CreateAccountDto createAccountDto);
    EntityModel<?> renameAccountByUuid(String uuid, RenameDto renameDto);
    EntityModel<?> changeTransferLimitByUuid
            (String uuid, ChangeTransferLimitDto changeTransferLimitDto);
    String closedAccByUuid(String uuid);
}
