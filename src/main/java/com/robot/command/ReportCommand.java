package com.robot.command;

import com.robot.RectangularTableDimension;
import com.robot.Robot;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReportCommand extends RobotCommand {

    public static final String COMMAND = "REPORT";

    public ReportCommand(){}

    public ReportCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        log.info(getRobot().report());
    }

    @Override
    public boolean isValid(RectangularTableDimension dimension) {
        return getRobot().isInTheTable();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Report Command");
        if(getRobot().isInTheTable()) builder.append(String.format(" on Robot: %s", getRobot()));
        return builder.toString();
    }
}
