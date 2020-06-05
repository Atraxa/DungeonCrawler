package com.company.Entities;

import com.company.DungeonMap;
import com.company.Entities.Entity;
import com.company.Position;
import com.company.TileType;

public class Elephant extends Entity {
    {
        displayTile=TileType.elephantTile;
        movementPoints=1;
    }
    public Elephant(Position inputCoordinates, DungeonMap inputDungeonMap){
        super(inputDungeonMap);
        entityCoordinates=inputCoordinates;
    }
    public Elephant(DungeonMap inputDungeonMap){ super(inputDungeonMap); }
}

