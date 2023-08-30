package com.example.mobile_banking_with_spring_hateoas.api.account_type;

import com.example.mobile_banking_with_spring_hateoas.api.account_type.web.AccountTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {
    AccountTypeDto mapAccountTypeToDto(AccountType accountType);
}
