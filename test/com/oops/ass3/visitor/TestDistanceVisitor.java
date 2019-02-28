/* TestDistanceVisitor */

package com.oops.ass3.visitor;

import com.oops.ass3.Parser;
import com.oops.ass3.Turtle;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


public class TestDistanceVisitor {

    private static Turtle turtle;
    private static Parser distanceFileParser;
    private static DistanceVisitor distanceVisitor;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        turtle = new Turtle();
        distanceFileParser = new Parser("src/turtle3.txt");
        distanceVisitor = new DistanceVisitor(turtle, distanceFileParser.getContext());
    }

    @Test
    public void TestTotalDistanceTraveled() {
        distanceVisitor.visit(distanceFileParser.getExpressionList());
        assertEquals(20,distanceVisitor.getTotalDistance());
    }

    @After
    public void after() {
        turtle = new Turtle();
    }
}