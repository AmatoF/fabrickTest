package com.fabrick.business.transaction;

import com.fabrick.api.exception.*;
import com.fabrick.api.transaction.TransactionResponse;
import com.fabrick.business.CommonService;
import com.fabrick.client.balance.BalanceClient;
import com.fabrick.client.transaction.TransactionClient;
import com.fabrick.persistence.transaction.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CommonService implements TransactionService {

    private TransactionClient transactionClient;

    private TransactionDao transactionDao;

    @Autowired
    public TransactionServiceImpl( TransactionClient transactionClient, TransactionDao transactionDao) {
        this.transactionClient = transactionClient;
        this.transactionDao = transactionDao;
    }

    @Override
    public TransactionResponse getTransactionList(Long accountId, String fromAccountingDate, String toAccountingDate) throws GetTransactionException, SaveTransactionException {
        try {
            logger.info("Calling client to get transaction list for accountId: "+accountId);
            TransactionResponse transactionResponse = transactionClient.getTransactionList(accountId, fromAccountingDate, toAccountingDate);
            logger.info("Response retrieved, writing transactionList to db");
            transactionDao.insertIntoTransactionHistory(transactionResponse.getPayload().getList());
            return transactionResponse;
        }catch (GetTransactionException e){
            logger.error("error retrieving transaction ", e);
            throw new GetTransactionException(e, "error retrieving transaction ", ErrorCode.CLIENT_ERROR);
        } catch (DaoException e) {
            logger.error("error saving transaction ", e);
            throw new SaveTransactionException(e, "error saving transaction ", ErrorCode.SAVE_TRANSACTION_ERROR);
        }
    }


}
