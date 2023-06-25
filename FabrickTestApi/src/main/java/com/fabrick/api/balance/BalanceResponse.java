package com.fabrick.api.balance;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BalanceResponse extends CommonObject {

     String status;
     String[] error;
     Balance payload;

     @Getter
     @Setter
     public class Balance{
          String date;
          BigDecimal balance;
          BigDecimal availableBalance;
          String currency;
     }



}
