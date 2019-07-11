package com.robot;

import lombok.Data;

@Data
public class Robot {

    private Position position;
    private boolean isInTheTable;

    public void place(Position position){
        this.position = position;
        this.isInTheTable = true;
    }

    public void move(){
        Direction direction = position.getDirection();
        switch (direction){
            case EAST:
                position.moveX(-1);
                break;
            case WEST:
                position.moveX(1);
                break;
            case SOUTH:
                position.moveY(-1);
                break;
            case NORTH:
                position.moveY(1);
                break;
        }
    }

    public void left(){
        position.setDirection(DirectionUtil.nextDirectionToTheLeft(position.getDirection()));
    }

    public void right(){
        position.setDirection(DirectionUtil.nextDirectionToTheRight(position.getDirection()));
    }

    public String report(){
        return position.toString();
    }

    @Override
    public String toString() {
        return report();
    }

}
