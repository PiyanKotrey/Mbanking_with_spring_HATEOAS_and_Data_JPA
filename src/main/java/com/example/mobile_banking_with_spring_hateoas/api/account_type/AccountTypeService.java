package com.example.mobile_banking_with_spring_hateoas.api.account_type;

import com.example.mobile_banking_with_spring_hateoas.api.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountTypeService {
    CollectionModel<?> findAllAccountType();
    EntityModel<?> findById(Long id);

}
