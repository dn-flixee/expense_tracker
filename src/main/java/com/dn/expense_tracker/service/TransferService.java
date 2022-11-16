package com.dn.expense_tracker.service;

import com.dn.expense_tracker.dto.TransferDto;
import com.dn.expense_tracker.entity.Transfer;

import java.util.List;

public interface TransferService {
    TransferDto saveTransfer(Transfer dtoToEntity);

    List<TransferDto> fetchTransferList();

    TransferDto fetchTransferById(Long transferId);

    TransferDto updateTransfer(Long transferId, Transfer transfer);

    TransferDto fetchTransferByName(String name);

    void deleteTransferById(Long transferId);

}
