package com.example.mobile_banking_with_spring_hateoas.api.account;

import com.example.mobile_banking_with_spring_hateoas.api.account.web.AccountDto;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.CreateAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto mapAccountToDto(Account account);
    Account mapCreateAccountDtoToAccount(CreateAccountDto createAccountDto);
}
