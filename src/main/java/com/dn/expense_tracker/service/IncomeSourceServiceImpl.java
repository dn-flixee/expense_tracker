package com.dn.expense_tracker.service;

import com.dn.expense_tracker.converter.AccountConverter;
import com.dn.expense_tracker.converter.IncomeSourceConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.IncomeSourceDto;
import com.dn.expense_tracker.entity.Account;
import com.dn.expense_tracker.entity.Income;
import com.dn.expense_tracker.entity.IncomeSource;
import com.dn.expense_tracker.repository.AccountRepository;
import com.dn.expense_tracker.repository.IncomeSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class IncomeSourceServiceImpl implements IncomeSourceService {
    @Autowired
    private IncomeSourceRepository incomeSourceRepository;
    @Autowired
    private IncomeSourceConverter incomeSourceConverter;

    @Override
    public IncomeSourceDto saveIncomeSource(IncomeSource incomeSource) {
        return incomeSourceConverter.entityToDto(incomeSourceRepository.save(incomeSource));
    }

    @Override
    public List<IncomeSourceDto> fetchIncomeSourceList() {
        return incomeSourceRepository.findAll().stream().map(incomeSource -> incomeSourceConverter.entityToDto(incomeSource)).collect(Collectors.toList());
    }

    @Override
    public IncomeSourceDto fetchIncomeSourceById(Long incomeSourceId) {

        return incomeSourceConverter.entityToDto(incomeSourceRepository.findById(incomeSourceId).get());
    }

    @Override
    public void deleteIncomeSourceById(Long incomeSourceId) {
        incomeSourceRepository.deleteById(incomeSourceId);
    }

    @Override
    public IncomeSourceDto updateIncomeSource(Long incomeSourceId, IncomeSource incomeSource) {
        IncomeSource incomeSourceDB = incomeSourceRepository.findById(incomeSourceId).get();

        if(Objects.nonNull(incomeSource.getName()) &&
                !"".equalsIgnoreCase(incomeSource.getName())){
            incomeSourceDB.setName(incomeSource.getName());
        }
        if(Objects.nonNull(incomeSource.getGoal())){
            incomeSourceDB.setGoal(incomeSource.getGoal());
        }

        return incomeSourceConverter.entityToDto(incomeSourceRepository.save(incomeSourceDB));
    }

//    @Override
//    public List<String> fetchIncomeSourceNames() {
//        incomeSourceRepository.findAll();
//    }

    @Override
    public IncomeSourceDto fetchIncomeSourceByName(String name) {
        return incomeSourceConverter.entityToDto(incomeSourceRepository.findByName(name));
    }
}
