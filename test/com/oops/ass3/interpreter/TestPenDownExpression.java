/* TestPenDownExpression.java */

package com.oops.ass3.interpreter;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TestPenDownExpression {

    private static Turtle turtle;
    private static Expression expression;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
    }

    @Test
    public void testPenDownExpression() {
        assertTrue(turtle.isPenUp());
        expression = new PenDown(turtle);
        expression.interpret(turtle, new Context());
        assertFalse(turtle.isPenUp());
    }

    @After
    public void after() {
        turtle = new Turtle();
    }
}