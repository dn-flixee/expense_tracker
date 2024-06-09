package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.ExpenseConverter;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.entity.ExpenseSource;
import com.dn.expense_tracker.service.ExpenseService;
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

    @PostMapping("/api/v1/expense_source")
    public ExpenseSource saveExpenseSource(@RequestBody ExpenseSource expenseSource){
        return expenseSourceService.saveExpenseSource(expenseSource);
    }

    @GetMapping("/api/v1/expense_source")
    public List<ExpenseSource> fetchExpenseSourceList(){
        return expenseSourceService.fetchExpenseSourceList();
    }

    @GetMapping("/api/v1/expense_source/{id}")
    public ExpenseSource fetchExpenseSourceById(@PathVariable("id") Long expenseSourceId){
        return expenseSourceService.fetchExpenseSourceById(expenseSourceId);
    }

    @DeleteMapping("/api/v1/expense_source/{id}")
    public String deleteExpenseSourceById(@PathVariable("id") Long expenseSourceId){
        expenseSourceService.deleteExpenseSourceById(expenseSourceId);
        return "ExpenseSource deleted Successfully";
    }

    @PutMapping("/api/v1/expense_source/{id}")
    public ExpenseSource updateExpenseSource(@PathVariable("id") Long expenseSourceId,@RequestBody ExpenseSource expenseSource){
        return expenseSourceService.updateExpenseSource(expenseSourceId,expenseSource);
    }
}
