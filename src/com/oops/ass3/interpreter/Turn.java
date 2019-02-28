//Turn.java
package com.oops.ass3.interpreter;

import com.oops.ass3.*;
import com.oops.ass3.visitor.Visitor;

public class Turn implements Expression {

    private Expression expression;

    public Turn(Expression expression) {
        this.expression = expression;

    }

    @Override
    public int interpret(Turtle turtle, Context context) {
        turtle.turn(expression.interpret(turtle, context));
        return 0;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}

