package com.company;


import com.company.Entities.*;
import static com.company.TileType.playerOneTile;
import static com.company.TileType.wallTile;

public class DisplayGrid {
    static int gridHeight = 7, gridWidth = 7;

    static void setDefaultHeight(int inputGridHeight) {
        gridHeight = inputGridHeight;
    }

    static void setDefaultWidth(int inputGridWidth) {
        gridWidth = inputGridWidth;
    }

    private DisplayGrid() {
    }

    /**
     * Populates and then displays Grid to Console
     */
    static void renderGridToConsole(Position inputPlayerCoordinate, DungeonMap sourceMap) throws CloneNotSupportedException{
        TileType[][] constructedGrid = populate(inputPlayerCoordinate, sourceMap);
        for (int y = 0; y < constructedGrid[0].length; y++) {
            for (int x = 0; x < constructedGrid.length; x++) {
                System.out.print(constructedGrid[x][y]);
            }
            System.out.print(System.lineSeparator());
        }
    }

    /**
     * Creates a TileType Grid dimensioned gridWidth by gridHeight, and then fills the cells based on coordinates present in the source DungeonMap.
     * It populates any coordinates not present in the DungeonMap as wallTile TileTypes and the location of the Player as playerOneTile TileType.
     */

    private static TileType[][] populate(Position inputPlayerCoordinate, DungeonMap sourceMap) throws CloneNotSupportedException{
        TileType[][] constructedGrid = new TileType[gridWidth][gridHeight];
        int offsetX = inputPlayerCoordinate.x - gridWidth / 2;
        int offsetY = inputPlayerCoordinate.y - gridHeight / 2;
        DungeonMap clonedMap = new DungeonMap(sourceMap);
        Entity.drawEntities(clonedMap);
        for (int x = 0; x < constructedGrid.length; x++) {
            for (int y = 0; y < constructedGrid[x].length; y++) {
                Position searchPosition = new Position(x + offsetX, y + offsetY);
                constructedGrid[x][y] = clonedMap.getTopTileType(searchPosition);
            }
        }
        return constructedGrid;
    }
}
