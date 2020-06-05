package com.company.Entities;

import com.company.DungeonMap;
import com.company.Position;
import com.company.TileType;

public class Lettuce extends Entity{
    {
        displayTile = TileType.lettuceTile;
        movementPoints = 0;
    }
    public Lettuce(Position inputCoordinates, DungeonMap inputDungeonMap){
        super(inputDungeonMap);
        entityCoordinates=inputCoordinates;
    }
    public Lettuce(DungeonMap inputDungeonMap){ super(inputDungeonMap); }

}
