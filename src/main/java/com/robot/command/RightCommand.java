package com.robot.command;

import com.robot.RectangularTableDimension;
import com.robot.Robot;

public class RightCommand extends RobotCommand {

    public static final String COMMAND = "RIGHT";

    public RightCommand(){}

    public RightCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        getRobot().right();
    }

    @Override
    public boolean isValid(RectangularTableDimension dimension) {
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
