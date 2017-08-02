/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;


public class Market {
    Queue q;
    double gains;
    int numShares = 0;
    
    public Market () {
        q = new Queue();
        gains = 0;
        this.numShares = numShares;
    }
    public void buyShares(int numShares, double price) {
        for (int i = 0; i < numShares; i++) {
            q.insert(price);
            this.numShares++;
        }
        
    }
    
    public void sellShares(int numShares, double SellPrice) {
        
        double buyPrices[] = new double[1000];
        for (int i = 0; i < numShares; i++) {
            buyPrices[i] = q.remove();
            this.numShares--;
        }
        double sumBP = sum(buyPrices);
        double gainsIncr = (numShares * SellPrice) - sumBP;
        gains += gainsIncr;
        System.out.println("Your gains increased by: " + gainsIncr);
    }
    
    //used by sellShares
    public double sum(double[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    }
    
    public double getGains() {
        return gains;
    }
}
