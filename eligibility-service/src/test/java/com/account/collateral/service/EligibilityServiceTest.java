package com.account.collateral.service;

import com.account.collateral.model.EligibleAssets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EligibilityServiceTest {

    @InjectMocks
    private EligibilityService eligibilityService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getEligibleAssetsTest(){
        EligibleAssets[] eligibleAssets = eligibilityService.getEligibleAssets();
        assertEquals(eligibleAssets.length,2);
    }

}
