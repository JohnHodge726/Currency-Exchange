package com.company;
import java.io.IOException;
import java.util.Scanner;
/* John Hodges
* Extra Credit Project
* */

public class CurrencyExchange {

    public static void main(String[] args) throws IOException {
        boolean isLooping = true;
        Scanner keyboard = new Scanner(System.in);
        Bank bank1 = new Bank("bank1.txt");
        Bank bank2 = new Bank("bank2.txt");
        Scanner userIn = new Scanner(System.in);

        do {
            System.out.print("Do you wish to buy or sell? ");
            String buyOrSell = userIn.nextLine();
            // buy portion
            if (buyOrSell.equalsIgnoreCase("buy")) {
                System.out.print("Which currency? ");
                String userCurrency = userIn.nextLine();
                if (bank1.supportCurrency(userCurrency) && bank2.supportCurrency(userCurrency)) {
                    System.out.println("There are two banks that can exchange " + userCurrency.toUpperCase() + ".");
                    System.out.print("How many " + userCurrency.toUpperCase() + "? ");
                    double userExchange = userIn.nextDouble();
                    System.out.println(bank1.quoteBuy(userExchange, userCurrency));

                } else if (bank1.supportCurrency(userCurrency)) {
                    System.out.println("There is one bank that can exchange " + userCurrency.toUpperCase());
                    System.out.print("How many " + userCurrency.toUpperCase() + "? ");
                    double userExchange = userIn.nextDouble();
                    System.out.println(bank1.quoteBuy(userExchange, userCurrency));
                } else if (bank2.supportCurrency(userCurrency)) {
                    System.out.println("There is one bank that can exchange " + userCurrency.toUpperCase());
                    System.out.print("How many " + userCurrency.toUpperCase() + "? ");
                    double userExchange = userIn.nextDouble();
                    System.out.println(bank2.quoteBuy(userExchange, userCurrency));
                } else {
                    System.out.println("I'm sorry. There is no such bank that supports " + userCurrency.toUpperCase() +
                            ". Please start again.");
                }

                // sell portion
            } else if (buyOrSell.equalsIgnoreCase("sell")) {
                System.out.print("Which currency? ");
                String userCurrency = userIn.nextLine();
                if (bank1.supportCurrency(userCurrency) && bank2.supportCurrency(userCurrency)) {
                    System.out.println("There are two banks that can exchange " + userCurrency.toUpperCase() + ".");
                    System.out.print("How many " + userCurrency.toUpperCase() + "? ");
                    double userExchange = userIn.nextDouble();
                    System.out.println(bank1.quoteSell(userExchange, userCurrency));
                    System.out.println(bank1.quoteBuy(userExchange, userCurrency));
                } else if (bank1.supportCurrency(userCurrency)) {
                    System.out.println("There is one bank that can exchange " + userCurrency.toUpperCase());
                    System.out.print("How many " + userCurrency.toUpperCase() + "? ");
                    double userExchange = userIn.nextDouble();
                    System.out.println(bank1.quoteSell(userExchange, userCurrency));
                } else if (bank2.supportCurrency(userCurrency)) {
                    System.out.println("There is one bank that can exchange " + userCurrency.toUpperCase());
                    System.out.print("How many " + userCurrency.toUpperCase() + "? ");
                    double userExchange = userIn.nextDouble();
                    System.out.println(bank2.quoteSell(userExchange, userCurrency));
                } else {
                    System.out.println("I'm sorry. There is no such bank that supports " + userCurrency.toUpperCase() +
                            ". Please start again.");
                    continue;
                }
            }
                else if (!buyOrSell.equalsIgnoreCase("buy") || !buyOrSell.equalsIgnoreCase("sell")) {
                    System.out.println("Please try again.");
                    continue;
                }

                System.out.print("Do you wish to perform another transaction? ");
                String userContinue = userIn.nextLine();
                if (userContinue.equalsIgnoreCase("yes")){
                    continue;
                }
                else if (userContinue.equalsIgnoreCase("no")){
                    isLooping = false;
                }

        } while (isLooping);
        System.exit(0);
    }
}

