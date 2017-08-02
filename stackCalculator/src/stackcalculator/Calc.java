/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcalculator;

/**
 *
 * @author Education Unlimited
 */
class Stack {

        private Double[] stack;
        private int size;

        // Constructor for stack
        public Stack() {
            stack = new Double[100];
            size = 0;
        }

        public void push(Double d) {
            stack[size] = d;
            size++;
            //adds the double d onto the stack, increments the size
        }

        public Double pop() {
            //removes the top number from the stack and returns it
            //make sure size is changed accordingly
            double foo = stack[size-1];
            stack[size-1] = null;
            size--;
            return foo;
        }

        public Double peek() {
            //returns the top number of the stack without modifying it
            return stack[size-1];
        }

        public int size() {
            //returns the current size of the stack
            return size;
        }

    }

    public class Calc {

        public Stack st;

        public Calc() {
            st = new Stack();
        }

        public void push(double n) {
            if (st.size() > 100) {
                throw new RuntimeException();
            } else {
                st.push(n);
            }
        }

        public double pop() {
            if (st.size() <= 0) {
                throw new RuntimeException();
            } else {
                return st.pop();
            }
        }

        public double peek() {
            if (st.size() <= 0) {
                throw new RuntimeException();
            } else {
                return st.peek();
            }
        }

        public void add() {
            if (st.size() < 2) {
                throw new RuntimeException();
            } else {
                double temp = st.pop() + st.pop();
                st.push(temp);
            }
        }

        public void subtract() {
            //subtracts the top 2 numbers on the stack, and pushes the result back onto the stack
            if (st.size() < 2) {
                throw new RuntimeException();
            } else {
                double temp = st.pop();
                st.push(st.pop() - temp);
            }
        }

        public void multiply() {
            if (st.size() < 2) {
                throw new RuntimeException();
            } else {
                double temp = st.pop() * st.pop();
                st.push(temp);
            }
        }

        public void divide() {
            if (st.size() < 2) {
                throw new RuntimeException();
            } else {
                double temp = st.pop();
                st.push(st.pop() / temp);
            }
        }

        public int depth() {
            return st.size();
        }

        public void reciprocal() {
            if (st.size() < 1) {
                throw new RuntimeException();
            } else {
                double temp = st.pop();
                temp = 1 / temp;
                st.push(temp);
            }
        }
        
        public void answer() {
            System.out.println(st.peek());
        }    

}
