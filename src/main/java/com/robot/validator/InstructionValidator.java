package com.robot.validator;

import com.robot.Direction;
import com.robot.command.*;
import org.apache.commons.lang3.StringUtils;

public class InstructionValidator {

    public boolean validate(String instruction){
        if(StringUtils.isBlank(instruction)) return false;
        String[] strs = instruction.toUpperCase().trim().split(" ");
        int length = strs.length;
        String command = strs[0];
        switch (command) {
            case LeftCommand.COMMAND:
            case RightCommand.COMMAND:
            case MoveCommand.COMMAND:
            case ReportCommand.COMMAND:
                return length == 1;
            case PlaceCommand.COMMAND:
                if(length == 2){
                    String[] params = strs[1].split(",");
                    if(params.length != 3) return false;
                    if(!(isPositiveInteger(params[0])
                        && isPositiveInteger(params[1]))) return false;
                    return Direction.isValidDirection(params[2]);
                }
                return false;
            default:
                return false;
        }
    }

    private boolean isPositiveInteger(String str){
        return str.matches("(0|[1-9]\\d*)");
    }
}
