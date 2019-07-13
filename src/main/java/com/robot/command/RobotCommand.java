package com.robot.command;

import com.robot.RectangularTableDimension;
import com.robot.Robot;
import lombok.Data;

@Data
public abstract class RobotCommand implements Command{

    private Robot robot;

    public boolean isValid(RectangularTableDimension dimension){
        return true;
    }

    public void executeOn(Robot robot){
        if(this.robot == null) {
            this.setRobot(robot);
        }
    }
}