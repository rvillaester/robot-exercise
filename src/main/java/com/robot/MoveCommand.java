package com.robot;

public class MoveCommand extends RobotCommand{

    public MoveCommand(){}

    public MoveCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        getRobot().move();
    }

    @Override
    public boolean isValid(int dimension) {
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
                isValid = x != dimension;
                break;
            case SOUTH:
                isValid = y != 0;
                break;
            case NORTH:
                isValid = y != dimension;
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
