package com.robot;

import com.robot.util.DirectionUtil;
import lombok.Data;

@Data
public class Robot {

    private String name;
    private Position position;

    public Robot(){
        this("Unspecified");
    }

    public Robot(String name){
        this.name = name;
    }

    public void place(Position position){
        this.position = position;
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

    public boolean isInTheTable(){
        return this.position != null;
    }


    @Override
    public String toString() {
        return report();
    }

}
