package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.IncomeDto;
import com.dn.expense_tracker.entity.Income;

import java.util.List;

public interface IncomeService {
    IncomeDto saveIncome(Income dtoToEntity);

    List<IncomeDto> fetchIncomeList();

    IncomeDto fetchIncomeById(Long incomeId);

    void deleteIncomeById(Long incomeId);

    IncomeDto updateIncome(Long incomeId, Income dtoToEntity);

    IncomeDto fetchIncomeByName(String name);
}
