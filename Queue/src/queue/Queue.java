/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Education Unlimited
 */

import java.util.NoSuchElementException;

public class Queue {

    private class Node {

        double price;
        Node next;
    }
    private Node head = null;
    private Node tail = null;

    public boolean isempty() {
        return (head == null);
    }

    public void insert(double newprice) {
        Node n = new Node();
        n.price = newprice;
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    public double remove() {
        if (head == null) {
            throw new NoSuchElementException();
        } 
        double temp = head.price;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return temp;
    }

    public double peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.price;
    }
    
}

