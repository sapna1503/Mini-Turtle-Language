package com.oops.ass3.visitor;

import com.oops.ass3.Context;
import com.oops.ass3.Memento;
import com.oops.ass3.Turtle;
import com.oops.ass3.interpreter.*;

import java.util.LinkedList;
import java.util.List;

public class MementoVisitor implements Visitor {

    private LinkedList<Memento> mementoList;
    private Turtle turtle;
    private Context context;

    public MementoVisitor(Turtle turtle, Context context) {
        this.mementoList = new LinkedList<>();
        this.turtle = turtle;
        this.context = context;
    }

    public LinkedList<Memento> getMementoList() {
        return mementoList;
    }

    //On Each Expression invoked add turtle state to list and interpret expression
    @Override
    public void visit(Move move) {
        mementoList.add(turtle.saveToMemento());
        move.interpret(turtle, context);
    }

    @Override
    public void visit(Turn turn) {
        mementoList.add(turtle.saveToMemento());
        turn.interpret(turtle, context);
    }

    @Override
    public void visit(PenUp penUp) {
        mementoList.add(turtle.saveToMemento());
        penUp.interpret(turtle, context);
    }

    @Override
    public void visit(PenDown penDown) {
        mementoList.add(turtle.saveToMemento());
        penDown.interpret(turtle, context);
    }

    @Override
    public void visit(Repeat repeat) {
        mementoList.add(turtle.saveToMemento());
        repeat.interpret(turtle, context);
    }

    @Override
    public void visit(List<Expression> list) {
        for (Expression expression : list) {
            expression.accept(this);
        }
    }

    //To get the last memento added, used to restore the state of turtle
    public Memento getMemento() {
        Memento lastMemento = mementoList.removeLast();
        return lastMemento;
    }
}
