package com.robot.command;

import com.robot.Position;
import com.robot.RectangularTableDimension;
import com.robot.Robot;
import lombok.Data;

@Data
public class PlaceCommand extends RobotCommand{

    public static final String COMMAND = "PLACE";

    private Position position;

    public PlaceCommand(){}

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
    public boolean isValid(RectangularTableDimension tableDimension) {
        int x = position.getX();
        int y = position.getY();
        if(x < 0 || y < 0){
            return false;
        }
        return (x <= tableDimension.getLength() && y <= tableDimension.getWidth());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Place Command on position: ");
        builder.append(position);
        return builder.toString();
    }
}
