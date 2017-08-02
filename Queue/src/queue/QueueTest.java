/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;


public class QueueTest {
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert(2.99);
        q.insert(9.99);
        System.out.println(q.peek());
        System.out.println(q.remove());
        q.insert(1.99);
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
    
}
