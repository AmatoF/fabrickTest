package com.fabrick.business.balance;

import com.fabrick.api.exception.ErrorCode;
import com.fabrick.api.exception.GetBalanceException;
import com.fabrick.business.CommonService;
import com.fabrick.client.balance.BalanceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl extends CommonService implements BalanceService {


    private BalanceClient balanceClient;

    @Autowired
    public BalanceServiceImpl( BalanceClient balanceClient) {
        this.balanceClient = balanceClient;
    }

    @Override
    public String getBalance(Long accountId) throws GetBalanceException {
        try {
            return "Account balance: ".concat(balanceClient.getBalance(accountId).getPayload().getBalance().toPlainString());
        }catch(Exception e){
            logger.error("error retrieving balance ", e);
            throw new GetBalanceException(e, "error retrieving balance ", ErrorCode.CLIENT_ERROR);
        }
    }


}
