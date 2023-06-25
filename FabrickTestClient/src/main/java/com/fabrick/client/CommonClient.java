package com.fabrick.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class CommonClient {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${base_url}")
    protected String baseUrl;

    @Value("${auth-schema}")
    protected String authSchema;
    @Value("${api-key}")
    protected String apiKey;
    @Value("${id_chiave}")
    protected String idChiave;

    @Autowired
    private FabrickRestTemplate restTemplate;


}
