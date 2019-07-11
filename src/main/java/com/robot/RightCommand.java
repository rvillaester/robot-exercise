package com.robot;

public class RightCommand implements RobotCommand{

    private Robot robot;

    public RightCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.right();
    }
}
