package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.IncomeSourceDto;
import com.dn.expense_tracker.entity.IncomeSource;

import java.util.List;

public interface IncomeSourceService {
    IncomeSourceDto saveIncomeSource(IncomeSource dtoToEntity);

    List<IncomeSourceDto> fetchIncomeSourceList();

    IncomeSourceDto fetchIncomeSourceById(Long incomeSourceId);

    IncomeSourceDto fetchIncomeSourceByName(String name);
    

    void deleteIncomeSourceById(Long incomeSourceId);

    IncomeSourceDto updateIncomeSource(Long incomeSourceId, IncomeSource dtoToEntity);

//    List<String> fetchIncomeSourceNames();
}
