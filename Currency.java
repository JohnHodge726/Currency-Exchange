package com.company;

public class Currency {
    private String currencyCode;
    private double exchangeRate;

    // TODO: this code is fine and complete
    public Currency(String cc, double er){
        this.currencyCode = cc;
        this.exchangeRate = er;
    }

    public void setCurrencyCode(String cc){
        this.currencyCode = cc;
    }

    public String getCurrencyCode(){
        return currencyCode;
    }

    public void setExchangeRate(double er){
        this.exchangeRate = er;
    }

    public double getExchangeRate(){
        return exchangeRate;
    }
}
