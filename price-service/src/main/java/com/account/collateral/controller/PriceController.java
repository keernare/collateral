package com.account.collateral.controller;

import com.account.collateral.model.AssetPrice;
import com.account.collateral.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping(path = "/getAssetPrice")
    public AssetPrice[] getAssetPrice() {
        return priceService.getAssetPrice();
    }

}
