package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DungeonMap {
    private String name;
    private HashMap<Position, ArrayList<TileType>> coordinateAndCorrespondingTileData;


    DungeonMap(String inputDungeonName) {
        name = inputDungeonName;
        coordinateAndCorrespondingTileData = new HashMap<Position, ArrayList<TileType>>();
    }

    /**
     * This method adds an Association to the DungeonMap, consisting of a coordinate and a tileType.
     * Each coordinate should have a 1-to-1 relationship with a tileType which is displayed if it is part of the rasterised Grid.
     * @param coordinatesForNewCell
     * @param inputTileType
     */
    DungeonMap addAssociation(Position coordinatesForNewCell, TileType inputTileType) {
        if(!coordinateAndCorrespondingTileData.containsKey(coordinatesForNewCell)){
            coordinateAndCorrespondingTileData.put(coordinatesForNewCell,new ArrayList<TileType>());
        }
        ArrayList<TileType> array = coordinateAndCorrespondingTileData.get(coordinatesForNewCell);
        array.add(inputTileType);
        coordinateAndCorrespondingTileData.put(coordinatesForNewCell, array);
        return this;
    }

    public String getName() {
        return name;
    }


    public TileType getTopTileType (Position targetCoordinates){
        ArrayList<TileType> array = coordinateAndCorrespondingTileData.get(targetCoordinates);
        int minDepth = Integer.MAX_VALUE;
        TileType outputTileType = TileType.wallTile;
        if(array!=null){
            for(TileType item:array){
                if(item.depthValue<minDepth) {
                    minDepth = item.depthValue;
                    outputTileType = item;
                }
            }
        }
        return outputTileType;
    }
 }

