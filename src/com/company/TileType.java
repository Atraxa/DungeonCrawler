package com.company;

/**
 * The TileType class contains a series of enumerated types and corresponding characters used to represent them when displayed in the Grid.
 */
public enum TileType{
    floorTile('0',2),
    wallTile('1',2),
    startTile('A',1),
    goalTile('Z',1),
    playerOneTile('G',0);
    char finalDisplayValue;
    int depthValue;
    TileType(char inputDisplayValue, int inputDepthValue){
        finalDisplayValue=inputDisplayValue;
        depthValue=inputDepthValue;
    }

    @Override
    public String toString() {
        return ""+finalDisplayValue;
    }
}
