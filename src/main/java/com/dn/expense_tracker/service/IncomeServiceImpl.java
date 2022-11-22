package com.dn.expense_tracker.service;

import com.dn.expense_tracker.converter.IncomeConverter;
import com.dn.expense_tracker.dto.IncomeDto;
import com.dn.expense_tracker.entity.Income;
import com.dn.expense_tracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private IncomeConverter incomeConverter;
    @Override
    public IncomeDto saveIncome(Income income) {
        return incomeConverter.entityToDto(incomeRepository.save(income));
    }

    @Override
    public List<IncomeDto> fetchIncomeList() {
        return incomeRepository.findAll().stream().map(income -> incomeConverter.entityToDto(income)).collect(Collectors.toList());
    }

    @Override
    public IncomeDto fetchIncomeById(Long incomeId) {
        return incomeConverter.entityToDto(incomeRepository.findById(incomeId).get());
    }

    @Override
    public void deleteIncomeById(Long incomeId) {
        incomeRepository.deleteById(incomeId);
    }

    @Override
    public IncomeDto updateIncome(Long incomeId, Income income) {
        Income incomeDB = incomeRepository.findById(incomeId).get();

        if (Objects.nonNull(income.getName()) &&
                !"".equalsIgnoreCase(income.getName())) {
            incomeDB.setName(income.getName());
        }
        if (Objects.nonNull(income.getAmount())) {
            incomeDB.setAmount(income.getAmount());
        }
        if (Objects.nonNull(income.getDate())) {
            incomeDB.setDate(income.getDate());
        }
        if (Objects.nonNull(income.getAccount())) {
            incomeDB.setAccount(income.getAccount());
        }
        if (Objects.nonNull(income.getIncomeSource())) {
            incomeDB.setIncomeSource(income.getIncomeSource());
        }

        return incomeConverter.entityToDto(incomeRepository.save(incomeDB));
    }
    @Override
    public IncomeDto fetchIncomeByName(String name) {
        return incomeConverter.entityToDto(incomeRepository.findByName(name));
    }

    @Override
    public double fetchIncomeTotalById(Long incomeSourceID) {
        return incomeRepository.fetchIncomeTotalById(incomeSourceID);
    }

}
