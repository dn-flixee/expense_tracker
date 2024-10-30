package com.dn.expense_tracker.service;

import com.dn.expense_tracker.converter.ExpenseConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.ExpenseDto;
import com.dn.expense_tracker.entity.Expense;
import com.dn.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseConverter expenseConverter;
    @Override
    public ExpenseDto saveExpense(Expense expense) {
        return expenseConverter.entityToDto(expenseRepository.save(expense));
    }

    @Override
    public List<ExpenseDto> fetchExpenseList() {
        return expenseRepository.findAll().stream().map(expense -> expenseConverter.entityToDto(expense)).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto fetchExpenseById(Long expenseId) {
        return expenseConverter.entityToDto(expenseRepository.findById(expenseId).get());
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, Expense expense) {
        Expense expenseDB = expenseRepository.findById(expenseId).get();

        if (Objects.nonNull(expense.getName()) &&
                !"".equalsIgnoreCase(expense.getName())) {
            expenseDB.setName(expense.getName());
        }
        if (Objects.nonNull(expense.getAmount())) {
            expenseDB.setAmount(expense.getAmount());
        }
        if (Objects.nonNull(expense.getDate())) {
            expenseDB.setDate(expense.getDate());
        }
        if (Objects.nonNull(expense.getAccount())) {
            expenseDB.setAccount(expense.getAccount());
        }
        if (Objects.nonNull(expense.getExpenseSource())) {
            expenseDB.setExpenseSource(expense.getExpenseSource());
        }

        return expenseConverter.entityToDto(expenseRepository.save(expenseDB));
    }

    @Override
    public ExpenseDto fetchExpenseByName(String name) {
        return expenseConverter.entityToDto(expenseRepository.findByName(name));
    }

    @Override
    public Map<String, List<Map<String, Object>>> getExpensesForLastYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Date startDate = calendar.getTime();
        Date endDate = new Date();

        List<Expense> expenses = expenseRepository.findByDateBetween(startDate, endDate);

        Map<String, Map<String, Double>> monthlyExpenses = new LinkedHashMap<>();

        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");

        for (Expense expense : expenses) {
            String month = monthFormat.format(expense.getDate());
            String sourceName = expense.getExpenseSource().getName();
            double amount = expense.getAmount();

            monthlyExpenses
                    .computeIfAbsent(month, k -> new HashMap<>())
                    .merge(sourceName, amount, Double::sum);
        }

        return monthlyExpenses.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .map(entry -> {
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("name", entry.getKey());
                                    map.put("value", entry.getValue());
                                    return map;
                                }).collect(Collectors.toList()),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));
    }
}
