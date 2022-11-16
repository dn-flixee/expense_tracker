package com.dn.expense_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TransferDto implements Serializable {
    private Long transferId;
    private String name;
    private double amount;
    private Date date;
    private String fromAccount;
    private String toAccount;
}