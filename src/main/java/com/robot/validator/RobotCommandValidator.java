package com.robot.validator;

import com.robot.RectangularTableDimension;
import com.robot.command.Command;
import com.robot.command.RobotCommand;

public class RobotCommandValidator implements CommandValidator {

    private RectangularTableDimension dimension;

    public RobotCommandValidator(RectangularTableDimension dimension){
        this.dimension = dimension;
    }

    @Override
    public boolean validate(Command command) {
        RobotCommand robotCommand = (RobotCommand) command;
        return robotCommand.isValid(dimension);
    }
}
