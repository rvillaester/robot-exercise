package com.robot;

public class MoveCommand implements RobotCommand{

    private Robot robot;

    public MoveCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.move();
    }
}
