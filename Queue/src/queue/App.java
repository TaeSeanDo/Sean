/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.Scanner;
import java.util.Random;
public class App {
    
    public static void main(String[] args) {
        Market market = new Market();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Hello, and welcome to the stock market thing.\n");
        
        boolean quit = false;
        while (!quit) {
            double stockPrice = random.nextInt(50) / 2;
            System.out.println("\nThe stock price today is: " + stockPrice
                    + "\n\nDo you want to (1) buy (2) sell (3) see gains or (4) quit?\n"
                    + "Enter an integer b/w 1 and 4");

            int choice = sc.nextInt();
            switch (choice) {
                case (1):
                    System.out.println("\nHow many stocks do you want to buy?");
                    int stockNumBuy = sc.nextInt();
                    market.buyShares(stockNumBuy, stockPrice);
                    break;
                case (2):
                    System.out.println("\nHow many stocks do you want to sell?");
                    int stockNumSell = sc.nextInt();
                    market.sellShares(stockNumSell, stockPrice);
                    break;
                case (3):
                    System.out.println("\nGains: " + market.getGains() + "\n");
                    break;
                case (4):
                    quit = true;
                    break;
                default:
                    System.out.println("\nPlease enter an integer between 1 and 4 (inclusive).\n");


            }
        }
        
    }
    
}
