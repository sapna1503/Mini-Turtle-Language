/* TestTurnExpression */
package com.oops.ass3.interpreter;

import com.oops.ass3.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


public class TestTurnExpression {

    private static Turtle turtle;
    private static Expression expression;
    private static Parser fileParser;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
        fileParser = new Parser("test/com/oops/ass3/interpreter/turtleTurnByVariable.txt");
    }

    @Test
    public void testTurnExpression() {
        expression = new Move(new Constant(10));
        expression.interpret(turtle, new Context());

        expression = new Turn(new Constant(90));
        expression.interpret(turtle, new Context());

        assertEquals("(10.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @Test
    public void testTurnExpressionByVariable() {
        fileParser.interpret(turtle, fileParser.getContext());
        assertEquals("(0.0,60.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @After
    public void after() {
        turtle = new Turtle();
    }
}