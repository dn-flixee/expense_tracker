package com.dn.expense_tracker.service;

import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.entity.ExpenseSource;

import java.util.List;

public interface ExpenseSourceService {
    ExpenseSource saveExpenseSource(ExpenseSource expenseSource);

    List<ExpenseSource> fetchExpenseSourceList();

    ExpenseSource fetchExpenseSourceById(Long expenseSourceId);

    void deleteExpenseSourceById(Long expenseSourceId);

    ExpenseSource updateExpenseSource(Long expenseSourceId, ExpenseSource expenseSource);
}
