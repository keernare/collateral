package com.account.collateral.service;

import com.account.collateral.model.AssetPrice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PriceService {

    public AssetPrice[] getAssetPrice(){
        ObjectMapper mapper = new ObjectMapper();
        AssetPrice[] assetPrices = null;
        try {
            assetPrices = mapper.readValue(new ClassPathResource("json/price.json").getFile(),
                    AssetPrice[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assetPrices;
    }
}
