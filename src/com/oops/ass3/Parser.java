//Parser.java
package com.oops.ass3;
import com.oops.ass3.interpreter.*;
import com.oops.ass3.visitor.Visitor;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Parser implements Expression {

    private String fileName;
    private static final String MOVE 	= "move";
    private static final String TURN 	= "turn";
    private static final String REPEAT 	= "repeat";
    private static final String END 	= "end";
    private static final String PENUP 	= "penUp";
    private static final String PENDOWN = "penDown";

    private Context context;
    private LinkedList<Expression> expressionList;
    private Turtle turtle;

    public LinkedList<Expression> getExpressionList() {
        return expressionList;
    }

    public Parser(String fileName) {
        this.fileName = fileName;
        context = new Context();
        turtle = new Turtle();
        expressionList = new LinkedList<>();
        try {
            read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public int interpret(Turtle turtle, Context context) {
        Iterator<Expression> iterator = expressionList.iterator();
        while (iterator.hasNext()) {
            iterator.next().interpret(turtle, context);
        }
        return 0;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private void read() throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        LinkedList<Expression> repeatExpressionList = new LinkedList<>();
        boolean isRepeat = false;
        String repeatSyntax = null;
        String currentItem;
        try {
            while (scanner.hasNextLine()) {
                currentItem = scanner.nextLine().trim();
                if (currentItem.startsWith(MOVE)) {
                    Expression moveExpression = new Move(getExpressionValue(currentItem));
                    if (isRepeat) {
                        repeatExpressionList.addLast(moveExpression);
                    } else {
                        expressionList.addLast(moveExpression);
                    }
                }
                else if (currentItem.startsWith(TURN)) {
                    Expression turnExpression = new Turn(getExpressionValue(currentItem));
                    if (isRepeat) {
                        repeatExpressionList.addLast(turnExpression);
                    } else {
                        expressionList.addLast(turnExpression);
                    }
                }
                else if (currentItem.startsWith(REPEAT)) {
                    repeatSyntax = currentItem;
                    isRepeat = true;
                }
                else if (currentItem.startsWith(END)) {
                    Expression repeatExpression = new Repeat(getExpressionValue(repeatSyntax), repeatExpressionList);
                    expressionList.addLast(repeatExpression);
                    isRepeat = false;
                }
                else if (currentItem.startsWith(PENDOWN)) {
                    Expression penDownExpression = new PenDown(turtle);
                    expressionList.addLast(penDownExpression);
                }
                else if (currentItem.startsWith(PENUP)) {
                    Expression penUpExpression = new PenUp(turtle);
                    expressionList.addLast(penUpExpression);
                }
                else if (currentItem.startsWith("#")) {
                    String[] variableString = currentItem.split("=");
                    context.setValues(variableString[0].trim(), variableString[1].trim());
                }
            }
        }
        finally {
            scanner.close();
        }
    }

    private Expression getExpressionValue(String argument) {
        String[] splitExpression = argument.split(" ");
        String constant;
        if (splitExpression[1].contains("#")) {
            constant = context.getValue((splitExpression[1]));
        } else {
            constant = splitExpression[1];
        }
        return new Constant(Integer.parseInt(constant));
    }

    @Override
    public void accept(Visitor visitor) {
    }
}
