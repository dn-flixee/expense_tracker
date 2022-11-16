package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.ExpenseSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseSourceRepository extends JpaRepository<ExpenseSource, Long> {
    public ExpenseSource findByName(String name);
}