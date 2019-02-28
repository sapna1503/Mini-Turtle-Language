/* TestMementoVisitor.java */

package com.oops.ass3.visitor;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import com.oops.ass3.interpreter.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TestMementoVisitor {

    private static Turtle turtle;
    private static Context context;
    private static MementoVisitor visitor;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
        context = new Context();
        visitor = new MementoVisitor(turtle, context);
    }

    @Test
    public void TestMoveAndRestoreMemento(){
        assertEquals("(0.0,0.0)", "(" + turtle.location().getX() + "," + turtle.location().getY() + ")" );

        Move move = new Move(new Constant(10));
        visitor.visit(move);
        visitor.visit(move);

        assertEquals("(20.0,0.0)", "(" + turtle.location().getX() + "," + turtle.location().getY() + ")" );

        turtle.restoreFromMemento(visitor.getMemento());

        assertEquals("(10.0,0.0)", "(" + turtle.location().getX() + "," + turtle.location().getY() + ")" );
    }

    @Test
    public void TestTurnAndRestoreMemento(){
        Turn turn = new Turn(new Constant(90));
        visitor.visit(turn);
        assertEquals(90, turtle.direction(),0 );

        turtle.restoreFromMemento(visitor.getMemento());
        assertEquals(0, turtle.direction(),0 );
    }


    @Test
    public void TestPenDownAndRestoreMemento(){
        assertTrue(turtle.isPenUp());

        PenDown penDown = new PenDown(turtle);
        visitor.visit(penDown);
        assertFalse(turtle.isPenUp());

        turtle.restoreFromMemento(visitor.getMemento());

        assertTrue(turtle.isPenUp());
    }

    @After
    public void after() {
        turtle = new Turtle();
        context = new Context();
        visitor = new MementoVisitor(turtle, context);
    }
}
