package com.fabrick.api.transaction;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.security.IdentityScope;
import java.util.List;

@Setter
@Getter
public class TransactionResponse extends CommonObject {

     String status;
     String[] error;
     TransactionList payload;

     @Getter
     @Setter
     public static class TransactionList{
          List<Transaction> list;

     }

     @Getter
     @Setter
     public static class Transaction{
          String transactionId;
          String operationId;
          String accountingDate;
          String valueDate;
          Type type;
          BigDecimal amount;
          String currency;
          String description;

     }

     @Getter
     @Setter
     public static class Type{
          String enumeration;
          String value;
     }



}
