/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.chooseyourownadventure;

import java.util.NoSuchElementException;

/**
 *
 * @author Education Unlimited
 */
public class DoublyLinkedListOfRooms {
        public enum position {
        FIRST, PREVIOUS, FOLLOWING, LAST
    };

    private class node {
        Room item;
        node prev;
        node next;

        private node() {
            this.item = new Room();
        }
    }

    private node first = null;
    private node current = null;
    private node last = null;
    private int currentPosition = 0;

    public void setPosition(position pos) {
        switch (pos) {
            case FIRST:
                current = first;
                currentPosition = 0;
                break;

            case PREVIOUS:
                if (current == first) {
                    System.out.println("Position is already first");
                } else {
                    current = current.prev;
                    currentPosition--;
                }
                break;
                

            case FOLLOWING:
                if (current == last) {
                    System.out.println("Position is already last");
                } else {
                    current = current.next;
                    currentPosition++;
                }
                break;
                

            case LAST:
                current = first;
                int lastIndex = 0;
                while (true) {
                    if (current.next == null) {
                        break;
                    }
                    current = current.next;
                    lastIndex++;
                }
                current = last;
                currentPosition = lastIndex;
                break;

        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public Room getItem() throws NoSuchElementException {
        if (current == null) {
            throw new NoSuchElementException();
        } else {
            return current.item;
        }
    }

    public int getPosition() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return currentPosition;
        }
    }

    public void delete() throws NoSuchElementException {
        if (first == null) {
            last = null;
            current = null;
            throw new NoSuchElementException();
        } else if (current == null) {
            throw new NoSuchElementException();
        } else {
            if (current == first) {
                first = first.next;
                first.prev = null;
                current = first;
            } else if (current == last) {
                last = last.prev;
                last.next = null;
                current = last;
                currentPosition--;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }

    public void insert(Room item, position pos) throws IllegalArgumentException {
        node n = new node();
        n.item = item;
        switch (pos) {
            case FIRST:
                if (first == null) {
                    first = n;
                    current = n;
                    last = n;
                } else {
                    n.next = first;
                    first.prev = n;
                    first = n;
                }
                setPosition(position.FIRST);
                break;


            case PREVIOUS:
                if (current == first) {
                    throw new IllegalArgumentException();
                }

                if (current.prev == first) {
                    n.prev = null;
                }
                n.next = current;
                current.prev.next = n;
                current.prev = n;
                current = n;
                currentPosition--;
                break;

            case FOLLOWING:
                if (current == last) {
                    throw new IllegalArgumentException();
                }
                n.next = current.next;
                n.prev = current;
                current.next.prev = n;
                current.next = n;
                current = n;
                currentPosition++;
                break;

            case LAST:
                if (first == null) {
                    first = n;
                    current = n;
                    last = n;
                } else {
                    n.prev = last;
                    last.next = n;
                    n.next = null;
                    last = n;
                    setPosition(position.LAST);
                }
                break;
                
        }

    }
    
    public void traverse() {
        node tmp= first;
        while (true) {
            if (tmp == null) {
                break;
            }
            System.out.println(tmp.item);
            tmp = tmp.next;
        }
    }

}
