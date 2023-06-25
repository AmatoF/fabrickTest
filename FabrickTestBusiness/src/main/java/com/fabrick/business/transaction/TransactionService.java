package com.fabrick.business.transaction;

import com.fabrick.api.exception.GetTransactionException;
import com.fabrick.api.exception.SaveTransactionException;
import com.fabrick.api.transaction.TransactionResponse;

public interface TransactionService {

    TransactionResponse getTransactionList(Long accountId, String fromAccountingDate, String toAccountingDate) throws GetTransactionException, SaveTransactionException;
}
