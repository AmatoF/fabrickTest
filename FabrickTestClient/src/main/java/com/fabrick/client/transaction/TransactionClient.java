package com.fabrick.client.transaction;

import com.fabrick.api.balance.BalanceResponse;
import com.fabrick.api.exception.ErrorCode;
import com.fabrick.api.exception.GetBalanceException;
import com.fabrick.api.exception.GetTransactionException;
import com.fabrick.api.transaction.TransactionResponse;
import com.fabrick.client.CommonClient;
import com.fabrick.client.FabrickRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionClient extends CommonClient {


    @Autowired
    FabrickRestTemplate restTemplate;

    private String transactionUrl="/api/gbs/banking/v4.0/accounts/{accountId}/transactions";


    public TransactionResponse getTransactionList(Long accountId, String fromAccountingDate, String toAccountingDate) throws GetTransactionException {

        String completeBalanceUrl = baseUrl+ transactionUrl;

        Map<String, Object> uriParams = new HashMap<>();
        uriParams.put("accountId", accountId);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(completeBalanceUrl).uriVariables(uriParams).queryParam("fromAccountingDate",fromAccountingDate).queryParam("toAccountingDate", toAccountingDate);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Auth-Schema", authSchema);
        header.set("Api-Key", apiKey);

        HttpEntity entity = new HttpEntity(header);

        try {
            ResponseEntity<TransactionResponse> response = restTemplate.restTemplateNoSSL().exchange(builder.toUriString(), HttpMethod.GET, entity,TransactionResponse.class);
            return response.getBody();
        }catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e){

            logger.error("Error retrieving balance", e);
            throw new GetTransactionException(e,"Error retrieving balance", ErrorCode.CLIENT_ERROR);
        }


    }


}
