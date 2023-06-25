package com.fabrick.persistence.transaction;

import com.fabrick.api.exception.DaoException;
import com.fabrick.api.transaction.TransactionResponse;

import java.util.List;

public interface TransactionDao {

    int insertIntoTransactionHistory(List<TransactionResponse.Transaction> transactionList) throws DaoException;

}
