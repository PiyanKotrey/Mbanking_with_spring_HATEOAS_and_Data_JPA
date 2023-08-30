package com.example.mobile_banking_with_spring_hateoas.api.account;

import com.example.mobile_banking_with_spring_hateoas.api.account.web.AccountController;
import com.example.mobile_banking_with_spring_hateoas.api.account.web.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AccountAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {
    private AccountMapper accountMapper;
    @Autowired
    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @SuppressWarnings("unchecked")
    public AccountAssembler() {
        super(AccountController.class,(Class<EntityModel<AccountDto>>) (Class<?>)EntityModel.class);
    }

    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapper.mapAccountToDto(entity);
        Link collectionLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountController.class)
                .getAllAccount()).withRel(IanaLinkRelations.COLLECTION);
        Link seftLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AccountController.class).getByUuid(entity.getUuid()))
                .withSelfRel();
        return EntityModel.of(accountDto,collectionLink,seftLink);
    }

    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }
}
