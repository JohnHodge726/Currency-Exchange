package com.company;
import java.io.IOException;
import java.text.DecimalFormat;

public class Quote {
    private DecimalFormat df = new DecimalFormat("##.00");
    private String bankIssueQuote;
    private String codeToBank;
    private double amtToBank;
    private String codeFromBank;
    private double amtFromBank;
    private double commissionRate;
    // dollar amount of the commission
    private double amountDollarComm;

    public Quote(String bankIssueQuote, String codeToBank, double amtToBank,
                 String codeFromBank, double amtFromBank, double commissionRate,
                 double amountDollarComm) throws IOException{
        this.bankIssueQuote = bankIssueQuote;
        this.codeToBank = codeToBank;
        this.amtToBank = amtToBank;
        this.codeFromBank = codeFromBank;
        this.amtFromBank = amtFromBank;
        this.commissionRate = commissionRate;
        this.amountDollarComm = amountDollarComm;
    }

    // commission amount should always be reported in US dollars
    public String toString(){
        return this.bankIssueQuote + " will give you " + df.format(this.amtToBank) + " " + this.codeToBank.toUpperCase() +
                " for " +
                df.format(this.amtFromBank) +
                " USD, after collecting a commission " +
                "of " + df.format(this.amountDollarComm) + " USD (" + df.format(commissionRate * 100) + "%)";
        // commission amount will always be in US dollars
    }
}
