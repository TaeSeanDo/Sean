/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Arrays;

/**
 *
 * @author Education Unlimited
 */
public class Tree {

    private class Node {

        String key;
        int value[] = new int[10];
        int size = 0;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) {
        if (tree.right != null) { //recursive for right side
            debugHelper(tree.right, depth + 1);
        }

        for (int i = 0; i < depth; i++) { //prints indenation
            System.out.printf("  ");
        }

        System.out.println(depth + " " + tree.key); //prints deptha and key

        if (tree.left != null) { //recursive for left side
            debugHelper(tree.left, depth + 1);
        }
    }

    private void outputHelper(Node tree) {
        if (tree.right != null) { //recursive for right side
            outputHelper(tree.right);
        }

        String vals = "";
        System.out.println("Size: " + tree.size);
        for (int i = 0; i < tree.size; i++) {
            if (i > 0) {
                vals += ", ";
            }
            vals += tree.value[i];
        }
        System.out.print(tree.key + " : " + vals); //prints key and colon
        System.out.println("");

        if (tree.left != null) { //recursive for left side
            outputHelper(tree.left);
        }
    }

    public void insert(String key, Integer linenum) {
        // Insert a word into the tree
        if (root == null) { //if root is null, make a new node for the root
            Node n = new Node();
            n.key = key;
            n.value[0] = linenum;
            n.size++;
            root = n;
        } else { //root is occupied
            Node current = root; //start at root
            Node parent;
            while (true) {
                parent = current;
                if (current.key.equals(key)) {
                    current.value[current.size] = linenum;
                    current.size++;
                    return;
                } else if (current.key.compareTo(key) < 0) { //try left
                    current = current.left;
                    if (current == null) {
                        Node n = new Node();
                        n.key = key;
                        n.value[n.size] = linenum;
                        n.size++;
                        parent.left = n;
                        return;
                    }
                } //end left if
                else { //try right
                    current = current.right;
                    if (current == null) {
                        Node n = new Node();
                        n.key = key;
                        n.value[n.size] = linenum;
                        n.size++;
                        parent.right = n;
                        return;
                    }
                } //end right if
            } //end while
        } //end else not root

    } //end insert()

    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }

}
