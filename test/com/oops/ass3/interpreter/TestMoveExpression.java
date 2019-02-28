//TestMoveExpression.java
package com.oops.ass3.interpreter;
import com.oops.ass3.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


public class TestMoveExpression {

    private static Turtle turtle;
    private static Parser fileParser;
    private static Expression expression;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
        fileParser = new Parser("test/com/oops/ass3/interpreter/turtleMoveByVariable.txt");
    }

    @Test
    public void testMoveExpression() {
        expression = new Move(new Constant(10));
        expression.interpret(turtle, new Context());
        assertEquals("(10.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");

        expression = new Move(new Constant(20));
        expression.interpret(turtle, new Context());
        assertEquals("(30.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @Test
    public void testMoveExpressionByVariable() {
        fileParser.interpret(turtle, fileParser.getContext());
        assertEquals("(3.0,0.0)","(" + turtle.location().getX() + "," + turtle.location().getY() + ")");
    }

    @After
    public void after() {
        turtle = new Turtle();
    }
}