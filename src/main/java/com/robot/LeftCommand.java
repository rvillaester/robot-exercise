package com.robot;

public class LeftCommand extends RobotCommand{

    public LeftCommand(){}

    public LeftCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        getRobot().left();
    }

    @Override
    public boolean isValid(int dimension) {
        return getRobot().isInTheTable();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Left Command");
        if(getRobot().isInTheTable()) builder.append(String.format(" on Robot: %s", getRobot()));
        return builder.toString();
    }
}
