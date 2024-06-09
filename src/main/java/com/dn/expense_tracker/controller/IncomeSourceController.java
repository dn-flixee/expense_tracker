package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.AccountConverter;
import com.dn.expense_tracker.converter.IncomeSourceConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.IncomeSourceDto;
import com.dn.expense_tracker.service.AccountService;
import com.dn.expense_tracker.service.IncomeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class IncomeSourceController {
    @Autowired
    private IncomeSourceService incomeSourceService;
    @Autowired
    private IncomeSourceConverter incomeSourceConverter;

    @PostMapping("/api/v1/incomeSource")
    public IncomeSourceDto saveIncomeSource(@RequestBody IncomeSourceDto incomeSourceDto){
        return incomeSourceService.saveIncomeSource(incomeSourceConverter.dtoToEntity(incomeSourceDto));
    }

    @GetMapping("/api/v1/incomeSource")
    public List<IncomeSourceDto> fetchIncomeSourceList(){
        return incomeSourceService.fetchIncomeSourceList();
    }

    @GetMapping("/api/v1/incomeSource/{id}")
    public IncomeSourceDto fetchIncomeSourceById(@PathVariable("id") Long incomeSourceId){
        return incomeSourceService.fetchIncomeSourceById(incomeSourceId);
    }

    @GetMapping("/api/v1/incomeSource/name/{name}")
    public IncomeSourceDto fetchIncomeSourceByName(@PathVariable("name") String name){
        return incomeSourceService.fetchIncomeSourceByName(name);
    }

//    public  List<String > fetchIncomeSourceNames(){
//        return incomeSourceService.fetchIncomeSourceNames();
//    }

    @DeleteMapping("/api/v1/incomeSource/{id}")
    public String deleteIncomeSourceById(@PathVariable("id") Long incomeSourceId){
        incomeSourceService.deleteIncomeSourceById(incomeSourceId);
        return "IncomeSource deleted Successfully";
    }

    @PutMapping("/api/v1/incomeSource/{id}")
    public IncomeSourceDto updateIncomeSource(@PathVariable("id") Long incomeSourceId, @RequestBody IncomeSourceDto incomeSourceDto){
        return incomeSourceService.updateIncomeSource(incomeSourceId,incomeSourceConverter.dtoToEntity(incomeSourceDto));
    }


}
