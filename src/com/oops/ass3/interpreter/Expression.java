//Expression
package com.oops.ass3.interpreter;

        import com.oops.ass3.Context;
        import com.oops.ass3.Turtle;
        import com.oops.ass3.visitor.Visitor;

public interface Expression {
    int interpret(Turtle turtle, Context context);

    void accept(Visitor visitor);
}
