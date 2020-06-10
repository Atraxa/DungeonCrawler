package com.company;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import com.company.Position;

public class RankedPosition extends Position implements Comparable {
    static Position goal = null;
    static void setGoal(Position inputGoal){
        goal=inputGoal;
    }
    RankedPosition previousNode = null;


    RankedPosition(Position positionToClone, RankedPosition inputPreviousNode){
        super(positionToClone);
        previousNode = inputPreviousNode;
    }

    @Override
    public int compareTo(Object o) {
        double comparedReturnValue=(this.distanceTo(goal)-((Position) o).distanceTo(goal));
        return (int) comparedReturnValue;
    }
}
