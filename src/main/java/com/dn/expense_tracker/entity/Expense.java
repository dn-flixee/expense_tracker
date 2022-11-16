package com.dn.expense_tracker.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long expenseId;
    private String name;
    private double amount;
    private Date date;

    @ManyToOne()
    @JoinColumn(
            name = "account",
            referencedColumnName = "accountId"
    )
    private Account account;

    @ManyToOne()
    @JoinColumn(
            name = "expense_source",
            referencedColumnName = "expenseSourceId"
    )
    private ExpenseSource expenseSource;
}
