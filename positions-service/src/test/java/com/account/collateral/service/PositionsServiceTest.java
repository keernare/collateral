package com.account.collateral.service;

import com.account.collateral.model.AccountPositions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PositionsServiceTest {

    @InjectMocks
    private PositionsService positionsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAccountPositionsTest(){
        AccountPositions[] accountPositions = positionsService.getAccountPositions();
        assertEquals(accountPositions.length,2);
    }
}
