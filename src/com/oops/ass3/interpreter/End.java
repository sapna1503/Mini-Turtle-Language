//End.java
package com.oops.ass3.interpreter;

import com.oops.ass3.Context;
import com.oops.ass3.Turtle;
import com.oops.ass3.visitor.Visitor;

public class End implements Expression {

    @Override
    public int interpret(Turtle turtle, Context context) {
        return 0;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
