package com.company;

import java.util.Objects;

/**
 * The Position Class describes the location of an Item within a two dimensional structure, providing an x- and a y-coordinate
 */
public class Position {
    int x, y;
    Position(int inputX, int inputY){
        x =inputX;
        y =inputY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
