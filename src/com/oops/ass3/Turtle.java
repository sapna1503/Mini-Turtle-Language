/*Turtle.java */

package com.oops.ass3;

import java.awt.geom.Point2D;

public class Turtle {

    private Point2D location;
    private int direction;
    private static final double PI = Math.PI;
    private int distance;
    private boolean isPenUp = true; // Turtle Start Condition


    public Turtle() {
        this.location = new Point2D.Double(0, 0); // Initialise Turtle Start Position
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    //Returns the current location of the turtle
    public Point2D location() {
        return location;
    }

    //Move the turtle distance units in the current direction if pen is down
    public void move(int distance) {
        if (isPenUp) {
            double radians = (PI) * ((double) direction / 180);
            double deltaX = Math.cos(radians) * distance;
            double deltaY = Math.sin(radians) * distance;
            double x = roundToTwoDigits(deltaX + this.location().getX());
            double y = roundToTwoDigits(deltaY + this.location().getY());
            this.location.setLocation(x, y);
            this.setDistance(distance + this.getDistance());

        } else {
            throw new UnsupportedOperationException("Turtle cannot draw right now.");
        }
    }

    private double roundToTwoDigits(Double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    //Add “degrees” to the current heading of the turtle
    public void turn(int degrees) {
        this.setDirection(this.direction() + degrees);
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }


    //Lift the pen up.
    public void penUp() {
        this.isPenUp = true;
    }

    //Put the pen down.
    public void penDown() {
        this.isPenUp = false;
    }

    //Return true if pen is up, false if the pen is down.
    public boolean isPenUp() {
        return isPenUp;
    }

    //Returns the current direction of the turtle.
    public int direction() {
        if (direction > 360) {
            return direction - 360;
        }
        return direction;
    }

    @Override
    public String toString() {
        return "Turtle Location : " + location.getX() + " " + location.getY();
    }

    //Turtle is Originator

    //Executed whenever state changes, turtle state's is saved
    public Memento saveToMemento() {
        Memento turtleMemento = new Memento(new Point2D.Double(this.location.getX(), this.location.getY()), this.direction, this.distance, this.isPenUp);
        return turtleMemento;
    }

    //To restore previous state from Memento.Turtle's properties are restored one step back from Memento.
    public void restoreFromMemento(Memento memento) {
        this.location = memento.getLocation();
        this.direction = memento.getDirection();
        this.distance = memento.getDistance();
        this.isPenUp = memento.checkIsPenUp();
    }
}