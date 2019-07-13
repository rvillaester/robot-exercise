package com.robot.util;

import com.robot.Direction;

import java.util.ArrayList;
import java.util.List;

public class DirectionUtil {

    private static List<Direction> directions = new ArrayList<>();

    static {
        directions.add(Direction.NORTH);
        directions.add(Direction.EAST);
        directions.add(Direction.SOUTH);
        directions.add(Direction.WEST);
    }

    public static Direction nextDirectionToTheRight(Direction currentDirection){
        int index = directions.indexOf(currentDirection);
        return (index == directions.size()-1) ? directions.get(0) : directions.get(index + 1);
    }

    public static Direction nextDirectionToTheLeft(Direction currentDirection){
        int index = directions.indexOf(currentDirection);
        return (index == 0) ? directions.get(directions.size()-1) : directions.get(index - 1);
    }
}
