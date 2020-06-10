package com.company.Entities;


import com.company.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Entity {
    Position entityCoordinates;
    protected TileType displayTile;
    protected int movementPoints;
    public Class targetEntityType;

    void randomiseCoordinates(DungeonMap inputDungeonMap){
        entityCoordinates=inputDungeonMap.getRandomPopulatedPosition();
    }


    protected Entity(DungeonMap inputDungeonMap){
        this.randomiseCoordinates(inputDungeonMap);
        listOfEntities.add(this);
    }

    void updateLocation(Position inputPosition){
        entityCoordinates=inputPosition;
    }

    public void setEntityCoordinates(Position inputEntityCoordinates){
        Position newCoordinates = new Position(inputEntityCoordinates);
        entityCoordinates=newCoordinates;
    }

    static ArrayList<Entity> listOfEntities = new ArrayList<>();
    public static void drawEntities(DungeonMap inputDungeonMap){
        for(Entity entityInPositionList : listOfEntities){
            inputDungeonMap.addAssociation(entityInPositionList.entityCoordinates,entityInPositionList.displayTile);
        }
    }

    public void moveEntityTowardsSpecificEntityType(DungeonMap inputDungeonMap) {
        Entity closestRelevantEntity = this.getClosestRelevantEntity(Lettuce.class);
        if (closestRelevantEntity == null) return;
        // Place the Entity on top of the targetItem if it has enough movement in a turn
        int numberOfMovementPointsRemaining = this.movementPoints;
        Stack<Position> remainingPath = AStar.returnShortestPath(inputDungeonMap, this.entityCoordinates, closestRelevantEntity.entityCoordinates);
        if(remainingPath.isEmpty()) return;
        while (numberOfMovementPointsRemaining-- > 0 && remainingPath.peek() != closestRelevantEntity.entityCoordinates) {
            this.entityCoordinates = remainingPath.pop();
        }
    }

    public static void moveAllEntities(DungeonMap inputDungeonMap) {
        for (Entity item : listOfEntities) {
            item.moveEntityTowardsSpecificEntityType(inputDungeonMap);
        }
    }


    Entity getClosestRelevantEntity(Class<? extends Entity> inputEntityType) {
        double distance = Double.MAX_VALUE;
        ArrayList<Entity> equidistantTargets = new ArrayList<Entity>();
        for (Entity item : listOfEntities) {
            if (!item.equals(this) && inputEntityType.isInstance(item)) {
                double currentItemDistance = this.entityCoordinates.distanceTo(item.entityCoordinates);
                if (currentItemDistance < distance) {
                    equidistantTargets.clear();
                    distance = currentItemDistance;
                }
                if (currentItemDistance == distance) {
                    equidistantTargets.add(item);
                }
            }
        }
        if (equidistantTargets.isEmpty()) return null;
        return equidistantTargets.get((int) (Math.random() * equidistantTargets.size()));
    }
}
