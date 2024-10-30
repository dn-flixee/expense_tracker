package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.ExpenseSourceDto;
import com.dn.expense_tracker.entity.ExpenseSource;

import java.util.List;

public interface ExpenseSourceService {
    ExpenseSource saveExpenseSource(ExpenseSource expenseSource);

    List<ExpenseSourceDto> fetchExpenseSourceList();

    ExpenseSourceDto fetchExpenseSourceById(Long expenseSourceId);

    void deleteExpenseSourceById(Long expenseSourceId);

    ExpenseSourceDto updateExpenseSource(Long expenseSourceId, ExpenseSource expenseSource);
}
