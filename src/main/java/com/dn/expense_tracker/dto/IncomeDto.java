package com.dn.expense_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.dn.expense_tracker.entity.Income} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IncomeDto implements Serializable {
    private Long incomeId;
    private String name;
    private Double amount;
    private Date date;
    private String accountName;
    private String incomeSourceName;
}