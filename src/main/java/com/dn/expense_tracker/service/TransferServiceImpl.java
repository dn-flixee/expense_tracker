package com.dn.expense_tracker.service;

import com.dn.expense_tracker.converter.TransferConverter;
import com.dn.expense_tracker.dto.TransferDto;
import com.dn.expense_tracker.entity.Transfer;
import com.dn.expense_tracker.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private TransferConverter transferConverter;
    @Override
    public TransferDto saveTransfer(Transfer transfer) {
        return transferConverter.entityToDto(transferRepository.save(transfer));
    }

    @Override
    public List<TransferDto> fetchTransferList() {

        return null;
    }

    @Override
    public TransferDto fetchTransferById(Long transferId) {

        return transferConverter.entityToDto(transferRepository.findById(transferId).get());
    }

    @Override
    public void deleteTransferById(Long transferId) {
        transferRepository.deleteById(transferId);
    }

    @Override
    public TransferDto updateTransfer(Long transferId, Transfer transfer) {
        Transfer transferDB = transferRepository.findById(transferId).get();

        if(Objects.nonNull(transfer.getName()) &&
                !"".equalsIgnoreCase(transfer.getName())){
            transferDB.setName(transfer.getName());
        }
        if(Objects.nonNull(transfer.getAmount())){
            transferDB.setAmount(transfer.getAmount());
        }
        if(Objects.nonNull(transfer.getDate())){
            transferDB.setDate(transfer.getDate());
        }
        if(Objects.nonNull(transfer.getFromAccount())){
            transferDB.setFromAccount(transfer.getFromAccount());
        }
        if(Objects.nonNull(transfer.getToAccount())){
            transferDB.setToAccount(transfer.getToAccount());
        }

        return transferConverter.entityToDto(transferRepository.save(transferDB));
    }

    @Override
    public TransferDto fetchTransferByName(String name) {
        return transferConverter.entityToDto(transferRepository.findByName(name));
    }
}
