package com.account.collateral.service;

import com.account.collateral.model.EligibleAssets;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class EligibilityService {

    public EligibleAssets[] getEligibleAssets(){
        ObjectMapper mapper = new ObjectMapper();
        EligibleAssets[] eligibleAssets = null;
        try {
            eligibleAssets = mapper.readValue(new ClassPathResource("json/eligibility.json").getFile(),
                    EligibleAssets[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eligibleAssets;
    }
}
