package com.dn.expense_tracker.service;

import com.dn.expense_tracker.converter.ExpenseConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.ExpenseDto;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseConverter expenseConverter;
    @Override
    public ExpenseDto saveExpense(Expense expense) {
        return expenseConverter.entityToDto(expenseRepository.save(expense));
    }

    @Override
    public List<ExpenseDto> fetchExpenseList() {
        return expenseRepository.findAll().stream().map(expense -> expenseConverter.entityToDto(expense)).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto fetchExpenseById(Long expenseId) {
        return expenseConverter.entityToDto(expenseRepository.findById(expenseId).get());
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, Expense expense) {
        Expense expenseDB = expenseRepository.findById(expenseId).get();

        if (Objects.nonNull(expense.getName()) &&
                !"".equalsIgnoreCase(expense.getName())) {
            expenseDB.setName(expense.getName());
        }
        if (Objects.nonNull(expense.getAmount())) {
            expenseDB.setAmount(expense.getAmount());
        }
        if (Objects.nonNull(expense.getDate())) {
            expenseDB.setDate(expense.getDate());
        }
        if (Objects.nonNull(expense.getAccount())) {
            expenseDB.setAccount(expense.getAccount());
        }
        if (Objects.nonNull(expense.getExpenseSource())) {
            expenseDB.setExpenseSource(expense.getExpenseSource());
        }

        return expenseConverter.entityToDto(expenseRepository.save(expenseDB));
    }

    @Override
    public ExpenseDto fetchExpenseByName(String name) {
        return expenseConverter.entityToDto(expenseRepository.findByName(name));
    }
}
