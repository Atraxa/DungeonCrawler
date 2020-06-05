package com.company;

import java.util.Objects;

/**
 * The Position Class describes the location of an Item within a two dimensional structure, providing an x- and a y-coordinate
 */
public class Position {
    int x, y;

    Position(int inputX, int inputY) {
        x = inputX;
        y = inputY;
    }

    public Position(Position positionToClone) {
        this.x = positionToClone.x;
        this.y = positionToClone.y;
    }


    public double distanceTo(Position targetPosition) {
        int dx=this.x-targetPosition.x;
        int dy=this.y-targetPosition.y;
        return Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
    }

    public int tileDistance(Position targetPosition){
        int dx=this.x-targetPosition.x;
        int dy=this.y-targetPosition.y;
        return Math.abs(dx)+Math.abs(dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != Position.class && getClass()!= RankedPosition.class)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
