package com.fabrick.api.banktransfer;

import com.fabrick.api.CommonObject;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankTransferRequest extends CommonObject {

     Creditor creditor;
     String executionDate;
     String uri;
     String description;
     BigDecimal amount;
     String currency;
     boolean isUrgent;
     boolean isInstant;
     String feeType;
     String feeAccountId;
     TaxRelief taxRelief;


    @Getter
    @Setter
    public static class TaxRelief extends CommonObject{

        String taxRelief;
        boolean isCondoUpgrade;
        String creditorFiscalCode;
        String beneficoaryType;
        NaturalPersonBeneficiary naturalPersonBeneficiary;
        LegalPersonBenficiary legalPersonBenficiary;

    }

    @Getter
    @Setter
    public static class NaturalPersonBeneficiary extends CommonObject{

        String fiscalCode1;
        String fiscalCode2;
        String fiscalCode3;
        String fiscalCode4;
        String fiscalCode5;

    }

    @Getter
    @Setter
    public static class LegalPersonBenficiary extends CommonObject{

        String fiscalCode;
        String legalRepresentativeFiscalCode;

    }


}
