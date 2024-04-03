package com.account.collateral.controller;

import com.account.collateral.model.AccountPositions;
import com.account.collateral.service.PositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest")
public class  PositionsController {

    @Autowired
    private PositionsService positionsService;

    @GetMapping(path = "/getAccountPositions")
    public AccountPositions[]  getAccountPositions() {
        return positionsService.getAccountPositions();
    }
}
