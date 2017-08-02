/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import stackcalculator.Calc;

/**
 *
 * @author Education Unlimited
 */
public class StackCalculatorTest {

    private double EPSILON = 1e-15;

    @Test
    public void basicTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(2.0);
        c.add();
        assertEquals(4.0, c.pop(), EPSILON);
    }

    @Test
    public void exprTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(3.0);
        c.multiply();
        c.answer();
        c.push(4.0);
        c.push(5.0);
        c.multiply();
        c.answer();
        c.add();
        assertEquals(26.0, c.pop(), EPSILON);
    }

    @Test
    public void pushDepthTest() {
        Calc c = new Calc();
        c.push(5.0);
        assertEquals(1, c.depth());
        c.push(6.0);
        assertEquals(2, c.depth());
        c.push(-10.0);
        assertEquals(3, c.depth());
    }

    @Test(expected = Exception.class)
    public void emptyPopTest() {
        Calc c = new Calc();
        c.pop();
    }

    @Test(expected = Exception.class)
    public void tooManyPopTest() {
        Calc c = new Calc();
        c.push(3.0);
        c.push(4.0);
        c.add();
        c.pop();
        c.pop();
    }

    @Test(expected = Exception.class)
    public void tooManyPushTest() {
        Calc c = new Calc();
        for (int i = 0; i < 1e6; i++) {
            c.push(100.0);
        }
    }

    @Test(expected = Exception.class)
    public void nopeekTest() {
        Calc c = new Calc();
        double v = c.peek();
    }

    @Test
    public void peekTest() {
        Calc c = new Calc();
        c.push(2.0);
        assertEquals(2.0, c.peek(), EPSILON);
        c.push(3.0);
        assertEquals(3.0, c.peek(), EPSILON);
        c.multiply();
        assertEquals(6.0, c.peek(), EPSILON);
        c.push(4.0);
        assertEquals(4.0, c.peek(), EPSILON);
        c.push(5.0);
        assertEquals(5.0, c.peek(), EPSILON);
        c.multiply();
        assertEquals(20.0, c.peek(), EPSILON);
        c.add();
        assertEquals(26.0, c.peek(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void underflowAddTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.add();
    }

    @Test
    public void singleSubtractTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.subtract();
        assertEquals(12.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleMultiplyTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(37.0);
        c.push(10.0);
        c.multiply();
        c.multiply();
        assertEquals(-370.0, c.pop(), EPSILON);
    }

    @Test
    public void addHundredTest() {
        Calc c = new Calc();
        int i;
        for (i = 0; i < 100; i++) {
            c.push(1.0);
        }
        for (i = 0; i < 99; i++) {
            c.add();
        }
        assertEquals(100.0, c.pop(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void underflowTest() {
        Calc c = new Calc();
        int i;
        for (i = 0; i < 100; i++) {
            c.push(1.0);
        }
        for (i = 0; i < 100; i++) {
            c.add();
        }
    }

    @Test
    public void depthAndPeekTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(3.0);
        c.push(4.0);
        c.push(1.0);
        c.push(2.0);
        c.subtract();
        c.add();
        assertEquals(3, c.depth(), EPSILON);
        assertEquals(3.0, c.peek(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void tooManyOperationsTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(3.0);
        c.push(4.0);
        c.push(1.0);
        c.push(2.0);
        c.subtract();
        c.add();
        c.multiply();
        c.multiply();
        c.divide();
    }

    @Test
    public void reciprocalTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.reciprocal();
        assertEquals(0.2, c.peek(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void emptyReciprocalTest() {
        Calc c = new Calc();
        c.reciprocal();
    }

    @Test
    public void pushPopTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(3.14);
        assertEquals(3.14, c.pop(), EPSILON);
        assertEquals(5.0, c.pop(), EPSILON);
        c.push(-2.5);
        assertEquals(-2.5, c.pop(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void underflowSubtractTest() {
        Calc c = new Calc();
        c.push(0.5);
        c.subtract();
    }

    @Test(expected = Exception.class)
    public void underflowMultiplyTest() {
        Calc c = new Calc();
        c.push(0.5);
        c.multiply();
    }

    @Test(expected = Exception.class)
    public void underflowDivideTest() {
        Calc c = new Calc();
        c.push(0.5);
        c.divide();
    }
    
    @Test
    public void singleAddTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.add();
        assertEquals(-8.0, c.pop(), EPSILON);
    }

    @Test
    public void singleMultiplyTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.multiply();
        assertEquals(-20.0, c.pop(), EPSILON);
    }
    
    @Test
    public void singleDivideTest() {
        Calc c = new Calc();
        c.push(10.0);
        c.push(-20.0);
        c.divide();
        assertEquals(-0.5, c.pop(), EPSILON);
    }
    
    @Test
    public void doubleAddTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(3.7);
        c.push(100.0);
        c.add();
        c.add();
        assertEquals(102.7, c.pop(), EPSILON);
    }
    
    @Test
    public void doubleSubtractTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(3.7);
        c.push(100.0);
        c.subtract();
        c.subtract();
        assertEquals(95.3, c.pop(), EPSILON);
    }
    
    @Test
    public void doubleDivideTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(4.0);
        c.push(100.0);
        c.divide();
        c.divide();
        assertEquals(-25.0, c.pop(), EPSILON);
    }
    
    @Test
    public void compoundTest() {
        //(2 1 12 3 / - +) reciprocal
        Calc c = new Calc();
        c.push(2);
        c.push(1);
        c.push(12);
        c.push(3);
        c.divide();
        c.subtract();
        c.add();
        c.reciprocal();
        assertEquals(-1.0, c.pop(), EPSILON);
    }
}
