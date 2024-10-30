package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.entity.ExpenseSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository <Expense, Long> {
    public Expense findByName(String name);

    List<Expense> findByDateBetween(Date startDate, Date endDate);
}
