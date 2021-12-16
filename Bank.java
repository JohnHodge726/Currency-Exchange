package com.company;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class Bank {
    private String nameOfBank;
    private double commissionRate;
    // using the Currency class
    private Currency c1, c2, c3;

    // takes file name as argument for constructor
    public Bank(String fileName) throws IOException {
        // Do not touch this code!!!
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        this.nameOfBank = scan.nextLine();
        this.commissionRate = Double.parseDouble(scan.nextLine());
        // TA said to use this way of initializing variables from the file
        String tempt1 = scan.nextLine();
        String tempt2 = scan.nextLine();
        String tempt3 = scan.nextLine();
        c1 = new Currency(tempt1.split(" ")[0], Double.parseDouble(tempt1.split(" ")[1]));
        c2 = new Currency(tempt2.split(" ")[0], Double.parseDouble(tempt2.split(" ")[1]));
        c3 = new Currency(tempt3.split(" ")[0], Double.parseDouble(tempt3.split(" ")[1]));

    }
    public boolean supportCurrency(String currencyCode){
        if (currencyCode.equalsIgnoreCase(this.c1.getCurrencyCode())|| currencyCode.equalsIgnoreCase(this.c2.getCurrencyCode()) ||
                currencyCode.equalsIgnoreCase(this.c3.getCurrencyCode())) {
            return true;
        }
        // else return false
            return false;
    }

    public double getRate(String currencyCode){
        // true
        if (currencyCode.equalsIgnoreCase(this.c1.getCurrencyCode())) {
            return c1.getExchangeRate();
        }
        else if (currencyCode.equalsIgnoreCase(this.c2.getCurrencyCode())) {
            return c2.getExchangeRate();
        }
        else if (currencyCode.equalsIgnoreCase(this.c3.getCurrencyCode())){
            return c3.getExchangeRate();
        }
        // bank does not support currency type
        else {
            return -1.0;
        }

    }
    // quoteBuy and quoteSell methods below this one
    public Quote quoteBuy(double foreignCurrency, String currencyCode) throws IOException {
        double com = this.commissionRate;
        double dollarsOwed = foreignCurrency / (getRate(currencyCode) * (1 - com));
        // ^^ customer will owe this amount
        double commission = com * dollarsOwed;
        // ^^ commission rate charged by the bank
        Quote qBuy = new Quote(this.nameOfBank, currencyCode, foreignCurrency, currencyCode,
                dollarsOwed, this.commissionRate, commission);
        return qBuy;
    }

    // foreign currency is the amount (JPY, GBP, etc..)???
    public Quote quoteSell(double foreignCurrency, String currencyCode) throws IOException{
        double rate = getRate(currencyCode); // exchange rate for bank
        double base = foreignCurrency / rate; // amount sent to bank divided by rate
        double commission = commissionRate * base; // commission per bank transaction
        double USDollarsCustomer = base - commission; // US Dollars to Customer

        Quote qSell = new Quote(this.nameOfBank, currencyCode, foreignCurrency,
                currencyCode, USDollarsCustomer,
                this.commissionRate, commission);
        return qSell;
    }

}
