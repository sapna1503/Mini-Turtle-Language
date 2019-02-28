//Visitor
package com.oops.ass3.visitor;

import com.oops.ass3.interpreter.*;
import java.util.List;

public interface Visitor {

    void visit(Move move);

    void visit(Turn turn);

    void visit(PenUp penUp);

    void visit(PenDown penDown);

    void visit(Repeat repeat);

    void visit(List<Expression> list);
}
