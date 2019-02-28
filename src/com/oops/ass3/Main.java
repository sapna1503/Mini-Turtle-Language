/* Main.java */
package com.oops.ass3;

import com.oops.ass3.interpreter.Constant;
import com.oops.ass3.interpreter.Move;
import com.oops.ass3.visitor.DistanceVisitor;
import com.oops.ass3.visitor.MementoVisitor;

public class Main {

    public static void main(String[] args) {

        Turtle turtle = new Turtle();
        System.out.println(turtle.toString());
        Parser fileParser = new Parser("src/turtle1.txt");
        fileParser.interpret(turtle, fileParser.getContext());
        System.out.println(turtle.toString());

        System.out.println("========================================================");
        Turtle distanceTurtle = new Turtle();
        Parser distanceFileParser = new Parser("src/turtle3.txt");
        DistanceVisitor visitor = new DistanceVisitor(distanceTurtle, distanceFileParser.getContext());
        visitor.visit(distanceFileParser.getExpressionList());
        System.out.println("Distance Traveled: " + visitor.getTotalDistance());


        System.out.println("========================================================");
        Move move = new Move(new Constant(10));
        Turtle mementoTurtle = new Turtle();
        Context context = new Context();
        MementoVisitor mementoVisitor = new MementoVisitor(mementoTurtle, context);
        mementoVisitor.visit(move);
        mementoVisitor.visit(move);
        mementoTurtle.restoreFromMemento(mementoVisitor.getMemento());

    }
}