package com.company.Entities;

import com.company.DungeonMap;
import com.company.Position;
import com.company.TileType;

public class Wolf extends Entity{
    {
        displayTile = TileType.wolfTile;
        movementPoints = 2;
    }
    public Wolf(Position inputCoordinates, DungeonMap inputDungeonMap){
        super(inputDungeonMap);
        entityCoordinates=inputCoordinates;
    }

    public Wolf(DungeonMap inputDungeonMap){
        super(inputDungeonMap);
    }

}
