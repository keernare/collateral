package com.account.collateral.controller;

import com.account.collateral.model.EligibleAssets;
import com.account.collateral.service.EligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest")
public class EligibilityController {

    @Autowired
    private EligibilityService eligibilityService;

    @GetMapping(path = "/getEligibleAssets")
    public EligibleAssets[] getEligibleAssets(){
        return eligibilityService.getEligibleAssets();
    }

}
