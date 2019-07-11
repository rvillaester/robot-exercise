package com.robot;

public class PlaceCommand extends RobotCommand{

    private Position position;

    public PlaceCommand(Position position){
        this.position = position;
    }

    public PlaceCommand(Robot robot, Position position){
        setRobot(robot);
        this.position = position;
    }

    @Override
    public void execute() {
        getRobot().place(position);
    }

    @Override
    public boolean isValid(int dimension) {
        int x = position.getX();
        int y = position.getY();
        if(x < 0 || y < 0){
            return false;
        }
        return (x <= dimension && y <= dimension);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Place Command on position: ");
        builder.append(position);
        return builder.toString();
    }
}
