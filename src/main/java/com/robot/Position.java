package com.robot;

import lombok.Data;

@Data
public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(){}

    public Position(int x, int y, Direction direction){
        this.direction = direction;
        this.x = x;
        this.y = y;
    }
}
