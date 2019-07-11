package com.robot;

public class PlaceCommand implements RobotCommand{

    private Robot robot;
    private Position position;

    public PlaceCommand(Robot robot, Position position){
        this.robot = robot;
        this.position = position;
    }

    @Override
    public void execute() {
        robot.place(position);
    }
}
