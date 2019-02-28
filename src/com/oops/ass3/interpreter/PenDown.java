//PenDown
package com.oops.ass3.interpreter;

import com.oops.ass3.*;
import com.oops.ass3.visitor.Visitor;

public class PenDown implements Expression {

    private Turtle turtle;

    public PenDown(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public int interpret(Turtle turtle, Context context) {
        turtle.penDown();
        return 0;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
