package com.fabrick.business.balance;

import com.fabrick.api.exception.GetBalanceException;

public interface BalanceService {

    String getBalance(Long accountId) throws GetBalanceException;
}
