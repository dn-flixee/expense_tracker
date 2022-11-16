package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.ExpenseConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.ExpenseDto;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.service.ExpenseService;
import com.dn.expense_tracker.service.ExpenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpenseConverter expenseConverter;

    @PostMapping("/api/v1/expense")
    public ExpenseDto saveExpense(@RequestBody ExpenseDto expenseDto){
        return expenseService.saveExpense(expenseConverter.dtoToEntity(expenseDto));
    }

    @GetMapping("/api/v1/expense")
    public List<ExpenseDto> fetchExpenseList(){
        return expenseService.fetchExpenseList();
    }

    @GetMapping("/api/v1/expense/{id}")
    public ExpenseDto fetchExpenseById(@PathVariable("id") Long expenseId){
        return expenseService.fetchExpenseById(expenseId);
    }

    @GetMapping("/api/v1/expense/name/{name}")
    public ExpenseDto fetchExpenseByName(@PathVariable("name") String name){
        return expenseService.fetchExpenseByName(name);
    }

    @DeleteMapping("/api/v1/expense/{id}")
    public String deleteExpenseById(@PathVariable("id") Long expenseId){
        expenseService.deleteExpenseById(expenseId);
        return "Expense deleted Successfully";
    }

    @PutMapping("/api/v1/expense/{id}")
    public ExpenseDto updateExpense(@PathVariable("id") Long expenseId,@RequestBody ExpenseDto expenseDto){
        return expenseService.updateExpense(expenseId,expenseConverter.dtoToEntity(expenseDto));
    }
}
