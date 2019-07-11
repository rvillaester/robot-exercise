package com.robot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReportCommand extends RobotCommand {

    public ReportCommand(){}

    public ReportCommand(Robot robot){
        setRobot(robot);
    }

    @Override
    public void execute() {
        log.info(getRobot().report());
    }

    @Override
    public boolean isValid(int dimension) {
        return getRobot().isInTheTable();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Report Command on Robot: ");
        builder.append(getRobot());
        return builder.toString();
    }
}
