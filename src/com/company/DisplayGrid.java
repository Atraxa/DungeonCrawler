package com.company;

import static com.company.TileType.playerOneTile;
import static com.company.TileType.wallTile;

public class DisplayGrid {
    static int gridHeight=7, gridWidth=7;
    static void setDefaultHeight(int inputGridHeight){ gridHeight = inputGridHeight; }
    static void setDefaultWidth(int inputGridWidth) { gridWidth = inputGridWidth; }

    private DisplayGrid(){
    }
    /**
     * Populates and then displays Grid to Console
     */
    static void renderGridToConsole(Position inputPlayerCoordinate, DungeonMap sourceMap){
        TileType[][] constructedGrid= populate(inputPlayerCoordinate, sourceMap);
        for(int y=0;y<constructedGrid[0].length;y++){
            for (int x=0;x<constructedGrid.length;x++){
                System.out.print(constructedGrid[x][y]);
            }
            System.out.print(System.lineSeparator());
        }
    }

    /**
     * Creates a TileType Grid dimensioned gridWidth by gridHeight, and then fills the cells based on coordinates present in the source DungeonMap.
     * It populates any coordinates not present in the DungeonMap as wallTile TileTypes and the location of the Player as playerOneTile TileType.
     */
    private static TileType[][] populate(Position inputPlayerCoordinate, DungeonMap sourceMap) {
        TileType[][] constructedGrid = new TileType[gridWidth][gridHeight];
        int offsetX = inputPlayerCoordinate.x - gridWidth / 2;
        int offsetY = inputPlayerCoordinate.y - gridHeight / 2;
        for (int x = 0; x < constructedGrid.length; x++) {
            for (int y = 0; y < constructedGrid[x].length; y++) {
                Position searchPosition = new Position(x + offsetX, y + offsetY);
                if (searchPosition.equals(inputPlayerCoordinate)) {
                    constructedGrid[x][y] = playerOneTile;
                } else if (sourceMap.contains(searchPosition)) {
                    constructedGrid[x][y] = sourceMap.getTileTypeForCoordinate(searchPosition);
                } else {
                    constructedGrid[x][y] = wallTile;
                }
            }

        }
        return constructedGrid;
    }
}
