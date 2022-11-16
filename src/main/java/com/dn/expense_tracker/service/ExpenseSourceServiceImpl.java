package com.dn.expense_tracker.service;

import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.entity.ExpenseSource;
import com.dn.expense_tracker.repository.ExpenseSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseSourceServiceImpl implements ExpenseSourceService {

    @Autowired
    ExpenseSourceRepository expenseSourceRepository;
    @Override
    public ExpenseSource saveExpenseSource(ExpenseSource expenseSource) {
        return expenseSourceRepository.save(expenseSource);
    }

    @Override
    public List<ExpenseSource> fetchExpenseSourceList() {
        return null;
    }

    @Override
    public ExpenseSource fetchExpenseSourceById(Long expenseSourceId) {
        return null;
    }

    @Override
    public void deleteExpenseSourceById(Long expenseSourceId) {

    }

    @Override
    public ExpenseSource updateExpenseSource(Long expenseSourceId, ExpenseSource expenseSource) {
        return null;
    }
}
