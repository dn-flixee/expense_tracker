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
@Table(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
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
            name = "income_source",
            referencedColumnName = "incomeSourceId"
    )
    private IncomeSource incomeSource;
}

