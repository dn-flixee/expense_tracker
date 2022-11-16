package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.entity.ExpenseSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository <Expense, Long> {
    public Expense findByName(String name);
}
