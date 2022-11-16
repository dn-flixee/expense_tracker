package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Long> {
    IncomeSource findByName(String incomeSourceName);
}