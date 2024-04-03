package com.account.collateral.service;

import com.account.collateral.config.Config;
import com.account.collateral.model.AccountPositions;
import com.account.collateral.model.AssetPrice;
import com.account.collateral.model.EligibleAssets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalServices {

    @Autowired
    private Config config;

    public AccountPositions[] getAccountPositions() {
        ResponseEntity<AccountPositions[]> accountPositions = new RestTemplate().getForEntity(config.getPositions(),
                AccountPositions[].class);
        return accountPositions.getBody();
    }

    public EligibleAssets[] getEligibleAssets() {
        ResponseEntity<EligibleAssets[]> eligibleAssets = new RestTemplate().getForEntity(config.getEligibility(),
                EligibleAssets[].class);
        return eligibleAssets.getBody();
    }

    public AssetPrice[] getAssetPrice() {
        ResponseEntity<AssetPrice[]> assetPrices = new RestTemplate().getForEntity(config.getPrice(),
                AssetPrice[].class);
        return assetPrices.getBody();
    }

}
