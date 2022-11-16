package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto saveAccount(Account account);

    List<AccountDto> fetchAccountList();

    AccountDto fetchAccountById(Long accountId);

    void deleteAccountById(Long accountId);

    AccountDto updateAccount(Long accountId, Account account);

    AccountDto fetchAccountByName(String name);
}
