package com.fabrick.business.banktransfer;

import com.fabrick.api.banktransfer.BankTransferRequest;
import com.fabrick.api.banktransfer.BankTransferResponse;
import com.fabrick.api.exception.BankTransferException;
import com.fabrick.api.exception.GetBalanceException;

public interface BankTransferService {

    BankTransferResponse createBankTransfer(Long accountId, BankTransferRequest bankTransferRequest) throws BankTransferException;
}
