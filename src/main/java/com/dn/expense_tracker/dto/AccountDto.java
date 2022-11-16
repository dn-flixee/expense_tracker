package com.dn.expense_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dn.expense_tracker.entity.Account} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AccountDto implements Serializable {
    private Long accountId;
    private String name;
    private double startingBalance;
    private Double type;
}