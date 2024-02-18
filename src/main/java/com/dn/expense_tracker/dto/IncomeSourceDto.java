package com.dn.expense_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dn.expense_tracker.entity.IncomeSource} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IncomeSourceDto implements Serializable {
    private Long incomeSourceId;
    private String name;
    private Double goal;
}