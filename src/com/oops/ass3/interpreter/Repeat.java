//Repeat
package com.oops.ass3.interpreter;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import com.oops.ass3.visitor.Visitor;

import java.util.*;

public class Repeat implements Expression {

    public int times;
    private Expression expression;
    private LinkedList<Expression> expressionList;

    public Repeat(int times) {
        this.times = times;
    }

    public Repeat(Expression expression, LinkedList<Expression> expressionList) {
        this.expression = expression;
        this.expressionList = expressionList;
    }

    @Override
    public int interpret(Turtle turtle, Context context) {
        if(expression != null) {
            for (int i = 0; i < expression.interpret(turtle, context); i++) {
                Iterator<Expression> iterator = expressionList.iterator();
                while (iterator.hasNext()) {
                    iterator.next().interpret(turtle, context);
                }
            }
        }

        return 0;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public LinkedList<Expression> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(LinkedList<Expression> expressionList) {
        this.expressionList = expressionList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}