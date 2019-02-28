//DistanceVisitor.java

package com.oops.ass3.visitor;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import com.oops.ass3.interpreter.*;
import java.util.List;

public class DistanceVisitor implements Visitor {

    private Turtle turtle;
    private Context context;
    private int totalDistance = 0;

    public DistanceVisitor(Turtle turtle, Context context) {
        this.turtle = turtle;
        this.context = context;
    }

    //On each move statement increment distance to existing distance to calculate total distance traveled
    @Override
    public void visit(Move move) {
        totalDistance += move.getExpression().interpret(turtle, context);
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    @Override
    public void visit(Turn turn) {
    }

    @Override
    public void visit(PenUp penUp) {
    }

    @Override
    public void visit(PenDown penDown) {
    }

    @Override
    public void visit(Repeat repeat) {
        for (int i = 0; i < repeat.getExpression().interpret(turtle, context); i++) {
            visit(repeat.getExpressionList());
        }
    }

    @Override
    public void visit(List<Expression> list) {
        for (Expression expression : list) {
            expression.accept(this);
        }
    }
}
