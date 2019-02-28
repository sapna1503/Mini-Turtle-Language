//Move.java
package com.oops.ass3.interpreter;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import com.oops.ass3.visitor.Visitor;

public class Move implements Expression {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Move(Expression expression) {
        this.expression = expression;

    }

    @Override
    public int interpret(Turtle turtle, Context context) {
        turtle.move(expression.interpret(turtle, context));
        return 0;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

