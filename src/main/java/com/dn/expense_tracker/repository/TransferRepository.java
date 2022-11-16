package com.dn.expense_tracker.repository;

import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
    public Transfer findByName(String name);
}