package com.account.collateral.controller;

import com.account.collateral.model.AccountCollateral;
import com.account.collateral.service.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/rest")
public class CollateralController {

    @Autowired
    private CollateralService collateralService;

    @GetMapping(path = "/calculateCollateralValue", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountCollateral> calculateCollateralValue(@RequestBody List<String> accounts) {
        this.validateRequest(accounts);
        return collateralService.calculateCollateralValue(accounts);
    }

    private void validateRequest(List<String> accounts){
        if(CollectionUtils.isEmpty(accounts)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Request should not be empty or null");
        }
    }

}
