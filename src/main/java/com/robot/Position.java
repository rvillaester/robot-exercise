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

    public void moveX(int steps){
        this.x = this.x + steps;
    }

    public void moveY(int steps){
        this.y = this.y + steps;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getX());
        builder.append(",");
        builder.append(getY());
        builder.append(",");
        builder.append(getDirection());
        return builder.toString();
    }

}
