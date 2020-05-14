package com.company;

/**
 * The TileType class contains a series of enumerated types and corresponding characters used to represent them when displayed in the Grid.
 */
public enum TileType{
    floorTile('0'),
    wallTile('1'),
    startTile('A'),
    goalTile('Z'),
    playerOneTile('G');
    char finalDisplayValue;
    TileType(char displayValue){
        finalDisplayValue=displayValue;
    }

    @Override
    public String toString() {
        return ""+finalDisplayValue;
    }
}
