//PenUp
package com.oops.ass3.interpreter;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import com.oops.ass3.visitor.Visitor;

public class PenUp implements Expression {

    private Turtle turtle;

    public PenUp(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public int interpret(Turtle turtle,Context context) {
        turtle.penUp();
        return 0;
    }

    @Override
    public void accept(Visitor visitor) {
    }
}
