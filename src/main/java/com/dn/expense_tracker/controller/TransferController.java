package com.dn.expense_tracker.controller;

import com.dn.expense_tracker.converter.AccountConverter;
import com.dn.expense_tracker.converter.TransferConverter;
import com.dn.expense_tracker.dto.AccountDto;
import com.dn.expense_tracker.dto.TransferDto;
import com.dn.expense_tracker.service.AccountService;
import com.dn.expense_tracker.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class TransferController {
    @Autowired
    private TransferService transferService;
    @Autowired
    private TransferConverter transferConverter;

    @PostMapping("/api/v1/transfer")
    public TransferDto saveTransfer(@RequestBody TransferDto transferDto){
        return transferService.saveTransfer(transferConverter.dtoToEntity(transferDto));
    }

    @GetMapping("/api/v1/transfer")
    public List<TransferDto> fetchTransferList(){
        return transferService.fetchTransferList();
    }

    @GetMapping("/api/v1/transfer/{id}")
    public TransferDto fetchTransferById(@PathVariable("id") Long transferId){
        return transferService.fetchTransferById(transferId);
    }

    @GetMapping("/api/v1/transfer/name/{name}")
    public TransferDto fetchTransferByName(@PathVariable("name") String name){
        return transferService.fetchTransferByName(name);
    }

    @DeleteMapping("/api/v1/transfer/{id}")
    public String deleteTransferById(@PathVariable("id") Long transferId){
        transferService.deleteTransferById(transferId);
        return "Transfer deleted Successfully";
    }

    @PutMapping("/api/v1/transfer/{id}")
    public TransferDto updateTransfer(@PathVariable("id") Long transferId, @RequestBody TransferDto transferDto){
        return transferService.updateTransfer(transferId,transferConverter.dtoToEntity(transferDto));
    }
}
