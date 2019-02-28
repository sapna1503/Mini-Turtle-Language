//Constant
package com.oops.ass3.interpreter;

        import com.oops.ass3.Context;
        import com.oops.ass3.Turtle;
        import com.oops.ass3.visitor.Visitor;

public class Constant implements Expression {
    private int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int interpret(Turtle turtle, Context context) {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
    }
}