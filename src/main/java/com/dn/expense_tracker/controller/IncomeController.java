package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.IncomeConverter;
import com.dn.expense_tracker.dto.IncomeDto;
import com.dn.expense_tracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @Autowired
    private IncomeConverter incomeConverter;

    @PostMapping("/api/v1/income")
    public IncomeDto saveIncome(@RequestBody IncomeDto incomeDto){
        return incomeService.saveIncome(incomeConverter.dtoToEntity(incomeDto));
    }

    @GetMapping("/api/v1/income")
    public List<IncomeDto> fetchIncomeList(){
        return incomeService.fetchIncomeList();
    }

    @GetMapping("/api/v1/income/{id}")
    public IncomeDto fetchIncomeById(@PathVariable("id") Long incomeId){
        return incomeService.fetchIncomeById(incomeId);
    }

    @GetMapping("/api/v1/income/name/{name}")
    public IncomeDto fetchIncomeByName(@PathVariable("name") String name){
        return incomeService.fetchIncomeByName(name);
    }

    @DeleteMapping("/api/v1/income/{id}")
    public String deleteIncomeById(@PathVariable("id") Long incomeId){
        incomeService.deleteIncomeById(incomeId);
        return "Income deleted Successfully";
    }

    @PutMapping("/api/v1/income/{id}")
    public IncomeDto updateIncome(@PathVariable("id") Long incomeId,@RequestBody IncomeDto incomeDto){
        return incomeService.updateIncome(incomeId,incomeConverter.dtoToEntity(incomeDto));
    }
}