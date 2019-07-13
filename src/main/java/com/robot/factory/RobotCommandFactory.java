package com.robot.factory;

import com.robot.command.*;
import org.apache.commons.lang3.StringUtils;

public class RobotCommandFactory {

    public RobotCommand getCommand(String command){
        if(StringUtils.isBlank(command)) return null;
        switch (command.toUpperCase()) {
            case LeftCommand.COMMAND: return new LeftCommand();
            case RightCommand.COMMAND: return new RightCommand();
            case MoveCommand.COMMAND: return new MoveCommand();
            case ReportCommand.COMMAND: return new ReportCommand();
            case PlaceCommand.COMMAND: return new PlaceCommand();
            default:
                return null;
        }
    }
}
