package com.assignment.fxtrading;
/*
  Created by Sumit Gole on 06/10/2021.
 */

import java.util.Scanner;

public class FXTradingApplication {
    public static Scanner scanner = new Scanner(System.in);
    private static final double getRate = 66.00d;
    private String customerName="";
    private String currencyPair="";
    private double rupees;
    private String rate="";

    public FXTradingApplication() {}
    public FXTradingApplication(String name, String currencyPair, double rupees, String rate) {
        this.customerName = name;
        this.currencyPair = currencyPair;
        this.rupees = rupees;
        this.rate = rate;
    }

    void getBookTrade() {
        System.out.println("Enter customer Name");
        customerName = scanner.next();
        System.out.println("Enter Currency Pair");
        currencyPair = scanner.next();

        if((currencyPair.equals("USDINR")) || (currencyPair.equals("usdinr"))){
            System.out.println("Enter amount to transfer");
            long amountToTransfer = scanner.nextInt();
            convertUSDtoINR(amountToTransfer);
            System.out.println("Do you want to get Rate");
            rate = scanner.next();
            if (rate.equals("Yes") || rate.equals("yes") || rate.equals("YES")){
                getRatePrint();
            }
        }

        System.out.println("\nBook/Cancel this trade?");
        System.out.println("1 : Book");
        System.out.println("2 : Cancel");
        int book = scanner.nextInt();

        switch (book) {
            case 1 -> System.out.println("Trade for USDINR has been booked with rate " + getRate + ", The amount of Rs " + rupees + " will be transferred in 2 working days to " + customerName + ".");
            case 2 -> System.out.println("Trade is Canceled.\n");
            default -> System.out.println("Invalid Option!! Please Enter Correct Option...");
        }
    }

    void convertUSDtoINR(long amountToTransfer){
        rupees = amountToTransfer * getRate;
    }

    void getRatePrint(){
        System.out.println("You are transferring INR " + rupees + " to " + customerName);
    }

    void printTrades(){
        System.out.println(" TradeNo\t CurrencyPair\t CustomerName\t Amount\t\t\t Rate ");
        System.out.println("\t" + "1" + "\t\t\t" + currencyPair + "\t\t\t" + customerName + "\t\tINR" + rupees + "\t\t" + getRate);
    }

    void showMenu() {
        char exit = '\0';
        int choice;

        do {
            System.out.println("\n1 : Book Trade");
            System.out.println("2 : Print Trades");
            System.out.println("3 : Exit\n");

            choice = scanner.nextInt();
            System.out.println("\n");

            switch (choice) {
                case 1 -> {
                    System.out.println("Book Trade-1");
                    getBookTrade();
                }
                case 2 -> {
                    System.out.println("Print Trades-2");
                    printTrades();
                }
                case 3 -> {
                    System.out.println("Do you really want to exit (Y/N)");
                    exit = scanner.next().charAt(0);
                }
                default -> System.out.println("Invalid Option!! Please Enter Correct Option...");
            }
        }
        while(choice != 3 || (exit == 'n'|| exit == 'N'));
        System.out.println("Bye - have a good day");
    }
}