package com.fabrick.api.banktransfer;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class BankTransferResponse extends CommonObject {

    public String moneyTransferId;
    public String status;
    public String direction;
    public Creditor creditor;
    public Debtor debtor;
    public String cro;
    public String uri;
    public String trn;
    public String description;
    public Date createdDatetime;
    public Date accountedDatetime;
    public String debtorValueDate;
    public String creditorValueDate;
    public Amount amount;
    public boolean isUrgent;
    public boolean isInstant;
    public String feeType;
    public String feeAccountId;
    public List<Fee> fees;
    public boolean hasTaxRelief;

    @Getter
    @Setter
    public class Amount{
        public int debtorAmount;
        public String debtorCurrency;
        public int creditorAmount;
        public String creditorCurrency;
        public String creditorCurrencyDate;
        public int exchangeRate;
    }

    @Getter
    @Setter
    public class Debtor{
        public String name;
        public Account account;
    }

    @Getter
    @Setter
    public class Fee{
        public String feeCode;
        public String description;
        public double amount;
        public String currency;
    }

}
