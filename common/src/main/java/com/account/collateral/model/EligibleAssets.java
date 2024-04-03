package com.account.collateral.model;

public class EligibleAssets {
    private boolean eligible;
    private String[] assetIds;
    private String[] accountIds;
    private double discount;

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public String[] getAssetIds() {
        return assetIds;
    }

    public void setAssetIds(String[] assetIds) {
        this.assetIds = assetIds;
    }

    public String[] getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(String[] accountIds) {
        this.accountIds = accountIds;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
