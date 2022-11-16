package com.dn.expense_tracker.converter;

import com.dn.expense_tracker.dto.IncomeSourceDto;
import com.dn.expense_tracker.entity.Income;
import com.dn.expense_tracker.entity.IncomeSource;
import org.springframework.stereotype.Component;

@Component
public class IncomeSourceConverter {
    public IncomeSourceDto entityToDto(IncomeSource incomeSource){

        IncomeSourceDto incomeSourceDto = new IncomeSourceDto();
        incomeSourceDto.setIncomeSourceId(incomeSource.getIncomeSourceId());
        incomeSourceDto.setName(incomeSource.getName());
        incomeSourceDto.setGoal(incomeSource.getGoal());
        return incomeSourceDto;
    }
    public IncomeSource dtoToEntity(IncomeSourceDto incomeSourceDto){

        IncomeSource incomeSource = new IncomeSource();
        incomeSource.setIncomeSourceId(incomeSourceDto.getIncomeSourceId());
        incomeSource.setName(incomeSource.getName());
        incomeSource.setGoal(incomeSource.getGoal());
        return incomeSource;
    }
}
