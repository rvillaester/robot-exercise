package com.robot;

import com.robot.command.RobotCommand;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RobotInstructions {

    private Robot robot;
    private List<RobotCommand> commands;

    public RobotInstructions(Robot robot){
        this.robot = robot;
    }

    public void addCommand(RobotCommand command){
        if(commands == null){
            commands = new ArrayList<>();
        }
        commands.add(command);
    }
}
