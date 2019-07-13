package com.robot;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum Direction {
    NORTH,EAST,SOUTH,WEST;

    public static boolean isValidDirection(String direction){
        if(StringUtils.isBlank(direction)) return false;
        return Arrays.stream(Direction.values()).filter(value -> value.name().equalsIgnoreCase(direction)).count() == 1;
    }

    public static Direction getDirection(String direction){
        if(StringUtils.isBlank(direction)) return null;
        return Arrays.stream(Direction.values()).filter(value -> value.name().equalsIgnoreCase(direction)).findFirst().orElse(null);
    }
}
