package com.dn.expense_tracker.converter;

import com.dn.expense_tracker.dto.ExpenseDto;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.repository.AccountRepository;
import com.dn.expense_tracker.repository.ExpenseSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ExpenseConverter {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ExpenseSourceRepository expenseSourceRepository;

    public ExpenseDto entityToDto(Expense expense){
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setExpenseId(expense.getExpenseId());
        expenseDto.setName(expense.getName());
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setDate(expense.getDate());
        expenseDto.setAccountName(expense.getAccount().getName());
        expenseDto.setExpenseSourceName(expense.getExpenseSource().getName());

        return expenseDto;
    }
    public Expense dtoToEntity(ExpenseDto dto){
        Expense expense = new Expense();
        expense.setExpenseId(dto.getExpenseId());
        expense.setName(dto.getName());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setAccount(accountRepository.findByName(dto.getAccountName()));
        expense.setExpenseSource(expenseSourceRepository.findByName(dto.getExpenseSourceName()));

        return expense;
    }
}
