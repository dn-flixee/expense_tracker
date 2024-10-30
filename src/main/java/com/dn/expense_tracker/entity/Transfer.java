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
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;
    private String name;
    private double amount;
    private Date date;

    @ManyToOne()
    @JoinColumn(
            name = "from_account",
            referencedColumnName = "accountId"
    )
    private Account fromAccount;

    @ManyToOne()
    @JoinColumn(
            name = "to_account",
            referencedColumnName = "accountId"
    )
    private Account toAccount;



}