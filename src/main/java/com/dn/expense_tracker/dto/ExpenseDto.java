package com.dn.expense_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.dn.expense_tracker.entity.Expense} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExpenseDto implements Serializable {
    private Long expenseId;
    private String name;
    private double amount;
    private Date date;
    private String accountName;
    private String expenseSourceName;
}