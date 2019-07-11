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
        builder.append("Left Command on Robot: ");
        builder.append(getRobot());
        return builder.toString();
    }
}
