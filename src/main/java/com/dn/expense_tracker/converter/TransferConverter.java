package com.dn.expense_tracker.converter;

import com.dn.expense_tracker.dto.TransferDto;
import com.dn.expense_tracker.entity.Transfer;
import com.dn.expense_tracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferConverter {
    @Autowired
    private AccountRepository accountRepository;

    public TransferDto entityToDto(Transfer transfer){

        TransferDto transferDto = new TransferDto();
        transferDto.setTransferId(transfer.getTransferId());
        transferDto.setName(transfer.getName());
        transferDto.setAmount(transfer.getAmount());
        transferDto.setDate(transfer.getDate());
        transferDto.setFromAccount(transfer.getFromAccount().getName());
        transferDto.setToAccount(transfer.getToAccount().getName());
        return transferDto;
    }
    public Transfer dtoToEntity(TransferDto transferDto){
        Transfer transfer = new Transfer();
        transfer.setTransferId(transferDto.getTransferId());
        transfer.setName(transferDto.getName());
        transfer.setAmount(transferDto.getAmount());
        transfer.setDate(transferDto.getDate());
        transfer.setFromAccount(accountRepository.findByName(transferDto.getFromAccount()));
        transfer.setToAccount(accountRepository.findByName(transferDto.getToAccount()));
        return transfer;
    }
}
