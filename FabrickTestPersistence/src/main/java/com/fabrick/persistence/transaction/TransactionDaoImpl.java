package com.fabrick.persistence.transaction;

import com.fabrick.api.exception.DaoException;
import com.fabrick.api.transaction.TransactionResponse;
import com.fabrick.persistence.CommonDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TransactionDaoImpl extends CommonDao implements TransactionDao{

    @Override
    public int insertIntoTransactionHistory(List<TransactionResponse.Transaction> transactionList) throws DaoException {
        Map<String, Object> params = new HashMap<>();
        params.put("transactionList", transactionList);
        try {
            return sqlSession.insert("insertIntoTransactionHistory", params);
        } catch (Exception e) {
            logger.error("Error saving transaction list", e);
            throw new DaoException(e, "Error saving transaction list");
        }
    }
}
