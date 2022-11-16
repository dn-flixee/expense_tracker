package com.dn.expense_tracker.service;

import com.dn.expense_tracker.converter.AccountConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountConverter accountConverter;
    @Override
    public AccountDto saveAccount(Account account) {
        return accountConverter.entityToDto(accountRepository.save(account));
    }

    @Override
    public List<AccountDto> fetchAccountList() {

        return null;
    }

    @Override
    public AccountDto fetchAccountById(Long accountId) {

        return accountConverter.entityToDto(accountRepository.findById(accountId).get());
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public AccountDto updateAccount(Long accountId, Account account) {
        Account accountDB = accountRepository.findById(accountId).get();

        if(Objects.nonNull(account.getName()) &&
                !"".equalsIgnoreCase(account.getName())){
            accountDB.setName(account.getName());
        }
        if(Objects.nonNull(account.getStartingBalance())){
            accountDB.setStartingBalance(account.getStartingBalance());
        }
        if(Objects.nonNull(account.getType())){
            accountDB.setType(account.getType());
        }

        return accountConverter.entityToDto(accountRepository.save(accountDB));
    }

    @Override
    public AccountDto fetchAccountByName(String name) {
        return accountConverter.entityToDto(accountRepository.findByName(name));
    }
}
