package com.fabrick.business.banktransfer;

import com.fabrick.api.banktransfer.BankTransferRequest;
import com.fabrick.api.banktransfer.BankTransferResponse;
import com.fabrick.api.exception.BankTransferException;
import com.fabrick.api.exception.ErrorCode;
import com.fabrick.api.exception.GetBalanceException;
import com.fabrick.api.exception.GetTransactionException;
import com.fabrick.business.CommonService;
import com.fabrick.business.balance.BalanceService;
import com.fabrick.business.transaction.TransactionService;
import com.fabrick.client.balance.BalanceClient;
import com.fabrick.client.banktransfer.BankTransferClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankTransferServiceImpl extends CommonService implements BankTransferService {

    private BankTransferClient bankTransferClient;

    @Autowired
    public BankTransferServiceImpl( BankTransferClient bankTransferClient) {
        this.bankTransferClient = bankTransferClient;
    }
    @Override
    public BankTransferResponse createBankTransfer(Long accountId, BankTransferRequest bankTransferRequest) throws BankTransferException {
        try {
            logger.info("Calling client to create a bank transfer for accountId: "+accountId);
            return bankTransferClient.createBankTransfer(accountId,bankTransferRequest);
        }catch (BankTransferException e){
            logger.error("error retrieving balance ", e);
            throw new BankTransferException(e, "error creating bank transfer ", ErrorCode.CLIENT_ERROR);
        }
    }
}
