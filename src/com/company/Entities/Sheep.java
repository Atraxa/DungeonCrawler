package com.company.Entities;

import com.company.DungeonMap;
import com.company.Position;
import com.company.TileType;

public class Sheep extends Entity{
    Class targetClassType = Lettuce.class;
    {
        displayTile = TileType.sheepTile;
        movementPoints = 1;
    }
    public Sheep(Position inputCoordinates, DungeonMap inputDungeonMap){
        super(inputDungeonMap);
        entityCoordinates=inputCoordinates;
;    }
    public Sheep(DungeonMap inputDungeonMap){
        super(inputDungeonMap);
    }
}
