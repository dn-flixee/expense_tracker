package com.dn.expense_tracker.converter;

import com.dn.expense_tracker.dto.ExpenseSourceDto;
import com.dn.expense_tracker.entity.ExpenseSource;
import org.springframework.stereotype.Component;

@Component
public class ExpenseSourceConverter {
    public ExpenseSourceDto entityToDto(ExpenseSource expenseSource){

        ExpenseSourceDto expenseSourceDto = new ExpenseSourceDto();
        expenseSourceDto.setExpenseSourceId(expenseSource.getExpenseSourceId());
        expenseSourceDto.setName(expenseSource.getName());
        expenseSourceDto.setBudget(expenseSource.getBudget());
        return expenseSourceDto;
    }
    public ExpenseSource DtoToEntity(ExpenseSourceDto expenseSourceDto){

        ExpenseSource expenseSource = new ExpenseSource();
        expenseSource.setExpenseSourceId(expenseSourceDto.getExpenseSourceId());
        expenseSource.setName(expenseSource.getName());
        expenseSource.setBudget(expenseSource.getBudget());
        return expenseSource;
    }
}
