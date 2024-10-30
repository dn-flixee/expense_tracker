package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.ExpenseConverter;
import com.dn.expense_tracker.dto.ExpenseSourceDto;
import com.dn.expense_tracker.entity.ExpenseSource;
import com.dn.expense_tracker.service.ExpenseSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ExpenseSourceController {
    @Autowired
    private ExpenseSourceService expenseSourceService;
    @Autowired
    private ExpenseConverter expenseConverter;

    @PostMapping("/api/v1/expenseSource")
    public ExpenseSource saveExpenseSource(@RequestBody ExpenseSource expenseSource){
        return expenseSourceService.saveExpenseSource(expenseSource);
    }

    @GetMapping("/api/v1/expenseSource")
    public List<ExpenseSourceDto> fetchExpenseSourceList(){
        return expenseSourceService.fetchExpenseSourceList();
    }

    @GetMapping("/api/v1/expenseSource/{id}")
    public ExpenseSourceDto fetchExpenseSourceById(@PathVariable("id") Long expenseSourceId){
        return expenseSourceService.fetchExpenseSourceById(expenseSourceId);
    }

    @DeleteMapping("/api/v1/expenseSource/{id}")
    public String deleteExpenseSourceById(@PathVariable("id") Long expenseSourceId){
        expenseSourceService.deleteExpenseSourceById(expenseSourceId);
        return "ExpenseSource deleted Successfully";
    }

    @PutMapping("/api/v1/expenseSource/{id}")
    public ExpenseSourceDto updateExpenseSource(@PathVariable("id") Long expenseSourceId, @RequestBody ExpenseSource expenseSource){
        return expenseSourceService.updateExpenseSource(expenseSourceId,expenseSource);
    }
}
