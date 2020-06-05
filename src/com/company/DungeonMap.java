package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class DungeonMap {
    private String name;
    private HashMap<Position, ArrayList<TileType>> coordinateAndCorrespondingTileData;

    DungeonMap(DungeonMap inputDungeonMap){
        this.name = inputDungeonMap.name;
        this.coordinateAndCorrespondingTileData= (HashMap<Position, ArrayList<TileType>>) inputDungeonMap.coordinateAndCorrespondingTileData.clone();
    }


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
    public DungeonMap addAssociation(Position coordinatesForNewCell, TileType inputTileType) {
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

    /**
     * Generates a random Position Object which is located within the Map (May be located off screen)
     * @return
     */
    public Position getRandomPopulatedPosition (){
        Set<Position> a = coordinateAndCorrespondingTileData.keySet();
        int randomIndex = (int)Math.floor((Math.random()*(a.size())));
        return (Position)a.toArray()[randomIndex];
    }
}