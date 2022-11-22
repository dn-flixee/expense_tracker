package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    public Income findByName(String name);

    @Query("SELECT sum(i.amount) FROM Income i where i.incomeSource.incomeSourceId = ?1")
    public Double fetchIncomeTotalById(Long incomeSourceId);
}