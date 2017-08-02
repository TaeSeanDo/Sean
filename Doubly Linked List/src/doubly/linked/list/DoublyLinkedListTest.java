/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubly.linked.list;

/**
 *
 * @author Education Unlimited
 */
public class DoublyLinkedListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList L = new DoublyLinkedList();
        
        L.insert("Wokfu", DoublyLinkedList.position.FIRST);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.insert("Elyotropes", DoublyLinkedList.position.FIRST);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.insert("Shu-shu", DoublyLinkedList.position.FOLLOWING);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.insert("book", DoublyLinkedList.position.FOLLOWING);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.setPosition(DoublyLinkedList.position.PREVIOUS);
        System.out.println(L.getPosition());
        
        L.insert("foo", DoublyLinkedList.position.PREVIOUS);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.insert("animated documentary", DoublyLinkedList.position.LAST);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.delete();
        L.traverse();
        System.out.println(L.getPosition());
        
        L.setPosition(DoublyLinkedList.position.FIRST);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.delete();
        L.traverse();
        System.out.println(L.getPosition());
        
        L.setPosition(DoublyLinkedList.position.FOLLOWING);
        L.traverse();
        System.out.println(L.getPosition());
        
        L.delete();
        L.traverse();
        System.out.println(L.getPosition());

    }

}
