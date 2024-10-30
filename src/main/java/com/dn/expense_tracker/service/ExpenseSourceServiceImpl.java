package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.ExpenseSourceDto;
import com.dn.expense_tracker.entity.ExpenseSource;
import com.dn.expense_tracker.repository.ExpenseSourceRepository;
import com.dn.expense_tracker.converter.ExpenseSourceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExpenseSourceServiceImpl implements ExpenseSourceService {

    @Autowired
    ExpenseSourceRepository expenseSourceRepository;
    
    @Autowired
    ExpenseSourceConverter expenseSourceConverter;
    
    @Override
    public ExpenseSource saveExpenseSource(ExpenseSource expenseSource) {
        return expenseSourceRepository.save(expenseSource);
    }

    @Override
    public List<ExpenseSourceDto> fetchExpenseSourceList() {
        return expenseSourceRepository.findAll().stream().map(expenseSource -> expenseSourceConverter.entityToDto(expenseSource)).collect(Collectors.toList());
        
    }

    @Override
    public ExpenseSourceDto fetchExpenseSourceById(Long expenseSourceId) {
        return expenseSourceConverter.entityToDto(expenseSourceRepository.findById(expenseSourceId).get());
    }

    @Override
    public void deleteExpenseSourceById(Long expenseSourceId) {
        expenseSourceRepository.deleteById(expenseSourceId);
    }

    @Override
    public ExpenseSourceDto updateExpenseSource(Long expenseSourceId, ExpenseSource expenseSource) {
        ExpenseSource expenseSourceDB = expenseSourceRepository.findById(expenseSourceId).get();

        if(Objects.nonNull(expenseSource.getName()) &&
                !"".equalsIgnoreCase(expenseSource.getName())){
            expenseSourceDB.setName(expenseSource.getName());
        }
        if(Objects.nonNull(expenseSource.getBudget())){
            expenseSourceDB.setBudget(expenseSource.getBudget());
        }

        return expenseSourceConverter.entityToDto(expenseSourceRepository.save(expenseSourceDB));
    }
}
