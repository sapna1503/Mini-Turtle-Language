/* TestRepeatExpression.java */
package com.oops.ass3.interpreter;

import com.oops.ass3.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


public class TestRepeatExpression {

    private static Turtle turtle;
    private static Expression expression;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
    }

    @Test
    public void testRepeatExpression() {
        expression = new Move(new Constant(10));
        expression.interpret(turtle, new Context());

        expression = new Turn(new Constant(90));
        expression.interpret(turtle, new Context());

        expression = new Repeat(4);
        expression = new Move(new Constant(10));
        expression = new Turn(new Constant(90));
        expression = new End();
        expression.interpret(turtle, new Context());

        assertEquals("(10.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @Test
    public void testNegativeRepeatExpression() {
        expression = new Move(new Constant(10));
        expression.interpret(turtle, new Context());

        expression = new Turn(new Constant(90));
        expression.interpret(turtle, new Context());

        expression = new Repeat(-1);
        expression = new Move(new Constant(10));
        expression = new Turn(new Constant(90));
        expression = new End();
        expression.interpret(turtle, new Context());

        assertEquals("(10.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @Test
    public void testRepeatZeroExpression() {
        expression = new Move(new Constant(10));
        expression.interpret(turtle, new Context());

        expression = new Turn(new Constant(90));
        expression.interpret(turtle, new Context());

        expression = new Repeat(0);
        expression = new Move(new Constant(10));
        expression = new Turn(new Constant(90));
        expression = new End();
        expression.interpret(turtle, new Context());

        assertEquals("(10.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @After
    public void after() {
        turtle = new Turtle();
    }

}