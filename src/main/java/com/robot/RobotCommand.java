package com.robot;

import lombok.Data;

@Data
public abstract class RobotCommand implements Command{

    private Robot robot;

    public boolean isValid(int dimension){
        return true;
    }

    public void executeOn(Robot robot){
        if(this.robot == null) {
            this.setRobot(robot);
        }
    }
}