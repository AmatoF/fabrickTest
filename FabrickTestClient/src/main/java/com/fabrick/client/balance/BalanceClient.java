package com.fabrick.client.balance;

import com.fabrick.api.balance.BalanceResponse;
import com.fabrick.api.exception.ErrorCode;
import com.fabrick.api.exception.GetBalanceException;
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
public class BalanceClient extends CommonClient {

    @Autowired
    FabrickRestTemplate restTemplate;

    private String balanceUrl="/api/gbs/banking/v4.0/accounts/{accountId}/balance";


    public BalanceResponse getBalance(Long accountId) throws Exception {
        logger.info("Calling client to get balance for accountId: "+accountId);

        String completeBalanceUrl = baseUrl+ balanceUrl;

        Map<String, Object> uriParams = new HashMap<>();
        uriParams.put("accountId", accountId);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(completeBalanceUrl).uriVariables(uriParams);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Auth-Schema", authSchema);
        header.set("Api-Key", apiKey);

        HttpEntity entity = new HttpEntity(header);

        try {
            ResponseEntity<BalanceResponse> response = restTemplate.restTemplateNoSSL().exchange(builder.toUriString(), HttpMethod.GET, entity,BalanceResponse.class);
            return response.getBody();
        }catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e){

            logger.error("Error retrieving balance", e);
            throw new GetBalanceException(e,"Error retrieving balance", ErrorCode.CLIENT_ERROR);
        }


    }


}
