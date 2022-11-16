package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    public Income findByName(String name);
}