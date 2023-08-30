package com.example.mobile_banking_with_spring_hateoas.api.account.web;

import com.example.mobile_banking_with_spring_hateoas.api.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;
    @GetMapping
    public CollectionModel<?> getAllAccount(){
        return accountService.findAllAccount();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> getByUuid(@PathVariable String uuid){
        return accountService.findAccountByUuid(uuid);
    }

    @PostMapping
    public EntityModel<?> createNewAccount(@RequestBody CreateAccountDto createAccountDto){
        return accountService.createNewAccount(createAccountDto);
    }

    @PostMapping("/{uuid}/rename")
    public EntityModel<?> renameAccount(@PathVariable String uuid,@RequestBody RenameDto renameDto){
        return accountService.renameAccountByUuid(uuid,renameDto);
    }

    @PostMapping("/{uuid}/transferLimit")
    public EntityModel<?> changeTransferLimit(
            @PathVariable String uuid,
            @RequestBody ChangeTransferLimitDto changeTransferLimitDto){
        return accountService.changeTransferLimitByUuid(uuid, changeTransferLimitDto);
    }
}
