//TestInterpreter
package com.oops.ass3.interpreter;

import com.oops.ass3.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TestInterpreter {

    private static Turtle turtle;
    private static Parser fileParser;
    private static Expression expression;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
        fileParser = new Parser("src/turtle1.txt");
    }

    @Test
    public void testInitialLocation() {
        assertEquals("(0.0,0.0)", "(" + turtle.location().getX() + "," + turtle.location().getY() + ")" );
    }

    @Test
    public void testTurtleEndLocation() {
        fileParser.interpret(turtle, fileParser.getContext());
        assertEquals("(22.99,27.5)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @Test
    public void testExpression() {
        expression = new Move(new Constant(10));
        expression.interpret(turtle, new Context());
        assertNotNull(expression);
    }

    @After
    public void after() {
        turtle = new Turtle();
    }
}