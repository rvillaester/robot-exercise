package com.robot.command;

import com.robot.Direction;
import com.robot.Position;
import com.robot.RectangularTableDimension;
import com.robot.Robot;

public class MoveCommand extends RobotCommand{

    public static final String COMMAND = "MOVE";

    public MoveCommand(){}

    public MoveCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        getRobot().move();
    }

    @Override
    public boolean isValid(RectangularTableDimension tableDimension) {
        if(!getRobot().isInTheTable()){
            return false;
        }

        Position position = getRobot().getPosition();
        Direction direction = position.getDirection();
        int x = position.getX();
        int y = position.getY();
        boolean isValid = true;
        switch (direction){
            case EAST:
                isValid = x != 0;
                break;
            case WEST:
                isValid = x != tableDimension.getLength();
                break;
            case SOUTH:
                isValid = y != 0;
                break;
            case NORTH:
                isValid = y != tableDimension.getWidth();
                break;
        }

        return isValid;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Move Command");
        if(getRobot().isInTheTable()) builder.append(String.format(" on Robot: %s", getRobot()));
        return builder.toString();
    }
}
