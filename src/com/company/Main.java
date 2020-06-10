package com.company;

import com.company.Entities.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
    // Setting Camera Dimensions
        DisplayGrid.setDefaultHeight(9);
        DisplayGrid.setDefaultWidth(9);
    // Creating DungeonMap instance
        DungeonMap dungeonOfGurion = new DungeonMap("dungeonOfDOOOOM");
        dungeonOfGurion.addAssociation(new Position(0,0),TileType.floorTile)
            .addAssociation(new Position(0,1),TileType.floorTile)
            .addAssociation(new Position(0,2),TileType.floorTile)
            .addAssociation(new Position(1,0),TileType.floorTile)
            .addAssociation(new Position(1,1),TileType.floorTile)
            .addAssociation(new Position(1,2),TileType.floorTile)
            .addAssociation(new Position(2,0),TileType.floorTile)
            .addAssociation(new Position(2,1),TileType.floorTile)
            .addAssociation(new Position(2,2),TileType.floorTile)
            .addAssociation(new Position(6,6),TileType.goalTile)
            .addAssociation(new Position(1,1),TileType.playerOneTile);

        //Entity ellie = new Elephant(new Position(1,5),dungeonOfGurion);
        Entity randomLettuce1 = new Lettuce(new Position(0,0),dungeonOfGurion);
        Entity randomLettuce2 = new Lettuce(new Position(2,2),dungeonOfGurion);
        Entity randomSheep1 = new Sheep(new Position(1,1),dungeonOfGurion);
        //Entity randomSheep2 = new Sheep(dungeonOfGurion);
        //Entity randomSheep3 = new Sheep(dungeonOfGurion);

        int a=0;
        DisplayGrid.renderGridToConsole(new Position(1,1),dungeonOfGurion);
        while(a++<5){
            Entity.moveAllEntities(dungeonOfGurion);
            System.out.println();
            DisplayGrid.renderGridToConsole(new Position(1,1),dungeonOfGurion);
        }
    }
}
