package com.account.collateral.service;

import com.account.collateral.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CollateralService {

    @Autowired
    ExternalServices externalServices;

    public List<AccountCollateral> calculateCollateralValue(List<String> accounts) {
        AccountPositions[] accountPositions = externalServices.getAccountPositions();

        EligibleAssets[] eligibleAssets = externalServices.getEligibleAssets();

        AssetPrice[] assetPrices = externalServices.getAssetPrice();

        List<AccountCollateral> accountCollateralList = new ArrayList<>();

        accounts.stream().forEach(account -> {
                    List<Position> positionsList = Arrays.stream(accountPositions)
                            .filter(ap -> ap.getAccountId().equalsIgnoreCase(account))
                            .findFirst()
                            .map(ap -> ap.getPositions())
                            .orElseGet(Collections::emptyList);

                    if (CollectionUtils.isNotEmpty(positionsList)) {
                        Double collateralValue = collateralValue(eligibleAssets, assetPrices, account, positionsList);
                        AccountCollateral accountCollateral = new AccountCollateral();
                        accountCollateral.setCollateralValue(collateralValue);
                        accountCollateral.setAccountId(account);
                        accountCollateralList.add(accountCollateral);
                    }
                }
        );
        return accountCollateralList;
    }

    private Double collateralValue(EligibleAssets[] eligibleAssets, AssetPrice[] assetPrices, String account,
                                   List<Position> positions) {
        return positions.stream()
                .map(position -> {
                    Double price = Arrays.stream(assetPrices)
                            .filter(ap -> ap.getAssetId().equalsIgnoreCase(position.getAssetId()))
                            .findFirst()
                            .map(ap -> ap.getPrice())
                            .orElse(0.0);
                    Double discount = Arrays.stream(eligibleAssets)
                            .filter(ea -> ea.isEligible() && Arrays.stream(ea.getAssetIds())
                                    .anyMatch(s -> s.equalsIgnoreCase(position.getAssetId())) &&
                                    Arrays.stream(ea.getAccountIds()).anyMatch(s -> s.equalsIgnoreCase(account)))
                            .map(ea -> ea.getDiscount())
                            .findFirst()
                            .orElse(0.0);
                    return position.getQuantity() * price * discount;
                }).reduce(0.0, Double::sum);
    }

}
