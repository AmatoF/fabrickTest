package com.fabrick.client.banktransfer;

import com.fabrick.api.banktransfer.BankTransferRequest;
import com.fabrick.api.banktransfer.BankTransferResponse;
import com.fabrick.api.exception.BankTransferException;
import com.fabrick.api.exception.ErrorCode;
import com.fabrick.api.exception.GetTransactionException;
import com.fabrick.api.transaction.TransactionResponse;
import com.fabrick.client.CommonClient;
import com.fabrick.client.FabrickRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Component
public class BankTransferClient extends CommonClient {


    @Autowired
    FabrickRestTemplate restTemplate;

    private String transactionUrl="/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";


    public BankTransferResponse createBankTransfer(Long accountId, BankTransferRequest bankTransferRequest) throws  BankTransferException {

        String completeBalanceUrl = baseUrl+ transactionUrl;

        Map<String, Object> uriParams = new HashMap<>();
        uriParams.put("accountId", accountId);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(completeBalanceUrl).uriVariables(uriParams);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Auth-Schema", authSchema);
        header.set("Api-Key", apiKey);

        HttpEntity entity = new HttpEntity(bankTransferRequest, header);

        try {
            ResponseEntity<BankTransferResponse> response = restTemplate.restTemplateNoSSL().exchange(builder.toUriString(), HttpMethod.POST, entity,BankTransferResponse.class);
            return response.getBody();
        }catch (Exception e){

            logger.error("Error creating bank transfer", e);
            throw new BankTransferException(e,"Error creating bank transfer", ErrorCode.CLIENT_ERROR);
        }


    }


}
