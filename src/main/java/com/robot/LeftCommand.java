package com.robot;

public class LeftCommand implements RobotCommand{

    private Robot robot;

    public LeftCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.left();
    }
}
