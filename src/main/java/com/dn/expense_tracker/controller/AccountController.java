package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.AccountConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountConverter accountConverter;

    @PostMapping("/api/v1/account")
    public AccountDto saveAccount(@RequestBody AccountDto accountDto){
        return accountService.saveAccount(accountConverter.dtoToEntity(accountDto));
    }

    @GetMapping("/api/v1/account")
    public List<AccountDto> fetchAccountList(){
        return accountService.fetchAccountList();
    }

    @GetMapping("/api/v1/account/{id}")
    public AccountDto fetchAccountById(@PathVariable("id") Long accountId){
        return accountService.fetchAccountById(accountId);
    }

    @GetMapping("/api/v1/account/name/{name}")
    public AccountDto fetchAccountByName(@PathVariable("name") String name){
        return accountService.fetchAccountByName(name);
    }

    @DeleteMapping("/api/v1/account/{id}")
    public String deleteAccountById(@PathVariable("id") Long accountId){
        accountService.deleteAccountById(accountId);
        return "Account deleted Successfully";
    }

    @PutMapping("/api/v1/account/{id}")
    public AccountDto updateAccount(@PathVariable("id") Long accountId, @RequestBody AccountDto accountDto){
        return accountService.updateAccount(accountId,accountConverter.dtoToEntity(accountDto));
    }
}
