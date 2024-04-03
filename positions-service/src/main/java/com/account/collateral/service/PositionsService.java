package com.account.collateral.service;

import com.account.collateral.model.AccountPositions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PositionsService {

    public AccountPositions[] getAccountPositions(){
        ObjectMapper mapper = new ObjectMapper();
        AccountPositions[] accountPositions = null;
        try {
            accountPositions = mapper.readValue(new ClassPathResource("json/positions.json").getFile(),
                    AccountPositions[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountPositions;
    }

}
