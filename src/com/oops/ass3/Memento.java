package com.oops.ass3;

import java.awt.geom.Point2D;

public class Memento {

    private Point2D location;
    private int direction;
    private int distance;
    private boolean isPenUp;

    public Memento(Point2D location, int direction, int distance, boolean isPenUp){
        this.location = location;
        this.direction = direction;
        this.distance = distance;
        this.isPenUp = isPenUp;
    }

    public Point2D getLocation() {
        return location;
    }

    public int getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }

    public boolean checkIsPenUp() {
        return isPenUp;
    }
}
