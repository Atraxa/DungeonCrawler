package com.company;

import java.util.HashMap;

public class DungeonMap {
    private String name;
    private HashMap<Position, TileType> coordinateAndCorrespondingTileData;


    DungeonMap(String inputDungeonName) {
        name = inputDungeonName;
        coordinateAndCorrespondingTileData = new HashMap<Position, TileType>();
    }

    /**
     * This method adds an Association to the DungeonMap, consisting of a coordinate and a tileType.
     * Each coordinate should have a 1-to-1 relationship with a tileType which is displayed if it is part of the rasterised Grid.
     * @param coordinatesForNewCell
     * @param inputTileType
     */
    DungeonMap setAssociation(Position coordinatesForNewCell, TileType inputTileType) {
        coordinateAndCorrespondingTileData.put(coordinatesForNewCell, inputTileType);
        return this;
    }

    public String getName() {
        return name;
    }

    public TileType getTileTypeForCoordinate(Position targetCoordinates) {
        return coordinateAndCorrespondingTileData.get(targetCoordinates);
    }
    public void setTileTypeForCoordinate(Position targetCoordinates, TileType newTileType){
        this.coordinateAndCorrespondingTileData.put(targetCoordinates,newTileType);
    }

    public boolean contains(Position searchPosition) {
        return coordinateAndCorrespondingTileData.containsKey(searchPosition);
    }

}

