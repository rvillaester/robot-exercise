package com.robot;

import lombok.Data;

@Data
public class RobotCommandExecutor {

    public void executeCommand(RobotCommand command){
        command.execute();
    }

}
