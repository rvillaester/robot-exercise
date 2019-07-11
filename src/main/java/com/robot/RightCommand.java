package com.robot;

public class RightCommand extends RobotCommand{

    public RightCommand(){}

    public RightCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        getRobot().right();
    }

    @Override
    public boolean isValid(int dimension) {
        return getRobot().isInTheTable();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Right Command");
        if(getRobot().isInTheTable()) builder.append(String.format(" on Robot: %s", getRobot()));
        return builder.toString();
    }
}
