package com.dn.expense_tracker.converter;

import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {
    public AccountDto entityToDto(Account account){

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(account.getAccountId());
        accountDto.setName(account.getName());
        accountDto.setStartingBalance(account.getStartingBalance());
        accountDto.setType(account.getType());
        return accountDto;
    }
    public Account dtoToEntity(AccountDto accountDto){
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setName(accountDto.getName());
        account.setStartingBalance(accountDto.getStartingBalance());
        account.setType(accountDto.getType());

        return account;
    }
}