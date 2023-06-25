package com.fabrick.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fabrick"})
public class FabrickTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabrickTestApplication.class, args);
    }


}
