package com.account.collateral.service;

import com.account.collateral.model.AccountCollateral;
import com.account.collateral.model.AccountPositions;
import com.account.collateral.model.AssetPrice;
import com.account.collateral.model.EligibleAssets;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CollateralServiceTest {
    @InjectMocks
    private CollateralService collateralService;

    @Mock
    private ExternalServices externalServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculateCollateralValueTest() {
        List<String> accounts = Arrays.asList("E1","E2");
        when(externalServices.getAccountPositions()).thenReturn(this.getAccountPositions());
        when(externalServices.getEligibleAssets()).thenReturn(this.getEligibleAssets());
        when(externalServices.getAssetPrice()).thenReturn(this.getAssetPrice());

        List<AccountCollateral> accountCollateralList = collateralService.calculateCollateralValue(accounts);
        Assertions.assertEquals(accountCollateralList.get(0).getCollateralValue(), 5481.0);
    }

    private AccountPositions[] getAccountPositions(){
        ObjectMapper mapper = new ObjectMapper();
        AccountPositions[] accountPositions = null;
        try {
            accountPositions = mapper.readValue(new File("src/test/resources/positions.json"),
                    AccountPositions[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountPositions;
    }

    private EligibleAssets[] getEligibleAssets(){
        ObjectMapper mapper = new ObjectMapper();
        EligibleAssets[] eligibleAssets = null;
        try {
            eligibleAssets = mapper.readValue(new File("src/test/resources/eligibility.json"),
                    EligibleAssets[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eligibleAssets;
    }

    private AssetPrice[] getAssetPrice(){
        ObjectMapper mapper = new ObjectMapper();
        AssetPrice[] assetPrices = null;
        try {
            assetPrices = mapper.readValue(new File("src/test/resources/price.json"),
                    AssetPrice[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assetPrices;
    }


}
