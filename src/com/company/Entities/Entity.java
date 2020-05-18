package com.company.Entities;


import com.company.Position;

public class Entity {
    Position entityCoordinates;
    protected char displayValue;
    protected int movementPoints;
    protected Entity(){}

    void setEntityCoordinates(Position inputEntityCoordinates){
        Position newCoordinates = new Position(inputEntityCoordinates);
        entityCoordinates=newCoordinates;
    }
}
