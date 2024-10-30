package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.ExpenseDto;
import com.dn.expense_tracker.entity.Expense;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    public ExpenseDto saveExpense(Expense expense);

    List<ExpenseDto> fetchExpenseList();

    ExpenseDto fetchExpenseById(Long expenseId);

    void deleteExpenseById(Long expenseId);

    ExpenseDto updateExpense(Long expenseId, Expense dtoToEntity);

    ExpenseDto fetchExpenseByName(String name);

    public Map<String, List<Map<String, Object>>> getExpensesForLastYear();
}
