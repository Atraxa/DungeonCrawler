package com.company;

public class Main {

    public static void main(String[] args) {
    // Setting Camera Dimensions
        DisplayGrid.setDefaultHeight(20);
        DisplayGrid.setDefaultWidth(20);
    // Creating DungeonMap instance
        DungeonMap dungeonOfGurion = new DungeonMap("dungeonOfDOOOOM");
        dungeonOfGurion.setAssociation(new Position(0,0),TileType.floorTile)
            .setAssociation(new Position(0,1),TileType.floorTile)
            .setAssociation(new Position(0,2),TileType.floorTile)
            .setAssociation(new Position(1,0),TileType.floorTile)
            .setAssociation(new Position(1,1),TileType.floorTile)
            .setAssociation(new Position(1,2),TileType.floorTile)
            .setAssociation(new Position(2,0),TileType.floorTile)
            .setAssociation(new Position(2,1),TileType.floorTile)
            .setAssociation(new Position(2,2),TileType.floorTile)
            .setAssociation(new Position(6,6),TileType.goalTile);

        DisplayGrid.renderGridToConsole(new Position(1,1),dungeonOfGurion);
    }
}
