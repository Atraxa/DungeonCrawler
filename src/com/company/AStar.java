package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStar {
    static ArrayList<RankedPosition> visitedNodes;
    static PriorityQueue<RankedPosition> nodesToVisit;
    static RankedPosition currentNode;

    private AStar() {
    }

    // consider impassable terrain (don't add them to nodes to visit
    public static Stack<Position> returnShortestPath(DungeonMap inputDungeonMap, Position startPosition, Position goalPosition) {
        visitedNodes = new ArrayList<RankedPosition>() ;
        nodesToVisit = new PriorityQueue<RankedPosition>();
        attemptSetCurrentNode(new RankedPosition(startPosition,null));
        RankedPosition.setGoal(goalPosition);
        Iterator<RankedPosition> a;

        // adds next iteration of nodes to our search and checks if they have already been visited
        do {
            if(currentNode.equals(goalPosition)){
                break;
            }
            if (!visitedNodes.contains(returnNorthPosition(currentNode))) {
                nodesToVisit.add(new RankedPosition(returnNorthPosition(currentNode),currentNode));
            }
            if (!visitedNodes.contains(returnEastPosition(currentNode))) {
                nodesToVisit.add(new RankedPosition(returnEastPosition(currentNode),currentNode));
            }
            if (!visitedNodes.contains(returnSouthPosition(currentNode))) {
                nodesToVisit.add(new RankedPosition(returnSouthPosition(currentNode),currentNode));
            }
            if (!visitedNodes.contains(returnWestPosition(currentNode))) {
                nodesToVisit.add(new RankedPosition(returnWestPosition(currentNode),currentNode));
            }
            a = nodesToVisit.iterator();
            RankedPosition suspectedClosestNode = a.next();
            a.remove();
            attemptSetCurrentNode(suspectedClosestNode);
        } while (a.hasNext());
        // go back over the RankedPositions to find the route taken
        RankedPosition endNode=currentNode;
        Stack<Position> shortestPath = new Stack<>();
        if(currentNode.previousNode!=null) {
            do {
                shortestPath.push(new Position(currentNode));
                currentNode = currentNode.previousNode;
            } while (currentNode.previousNode != null);
            return shortestPath;
        }
        return shortestPath;
    }

    private static boolean attemptSetCurrentNode(RankedPosition inputPosition) { ;
        if(!visitedNodes.contains(inputPosition)){
            visitedNodes.add(inputPosition);
            currentNode =  inputPosition;
            return true;
        }
        return false;
    }

    static Position returnNorthPosition(Position inputPosition) {
        return new Position(inputPosition.x, inputPosition.y + 1);
    }

    static Position returnEastPosition(Position inputPosition) {
        return new Position(inputPosition.x + 1, inputPosition.y);
    }

    static Position returnSouthPosition(Position inputPosition) {
        return new Position(inputPosition.x, inputPosition.y - 1);
    }

    static Position returnWestPosition(Position inputPosition) {
        return new Position(inputPosition.x - 1, inputPosition.y);
    }
}
