package com.dn.expense_tracker.converter;

import com.dn.expense_tracker.dto.IncomeDto;
import com.dn.expense_tracker.entity.Income;
import com.dn.expense_tracker.repository.AccountRepository;
import com.dn.expense_tracker.repository.IncomeSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncomeConverter {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private IncomeSourceRepository incomeSourceRepository;

    public IncomeDto entityToDto(Income income){
        IncomeDto dto = new IncomeDto();
        dto.setIncomeId(income.getIncomeId());
        dto.setName(income.getName());
        dto.setAmount(income.getAmount());
        dto.setDate(income.getDate());
        dto.setAccountName(income.getAccount().getName());
        dto.setIncomeSourceName(income.getIncomeSource().getName());

        return dto;
    }
    public Income dtoToEntity(IncomeDto dto){
        Income income = new Income();
        income.setIncomeId(dto.getIncomeId());
        income.setName(dto.getName());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        income.setAccount(accountRepository.findByName(dto.getAccountName()));
        income.setIncomeSource(incomeSourceRepository.findByName(dto.getIncomeSourceName()));

        return income;
    }
}
