package com.robot;

public class RobotCommandValidator implements CommandValidator {

    private int dimension;

    public RobotCommandValidator(int dimension){
        this.dimension = dimension;
    }

    @Override
    public boolean validate(Command command) {
        RobotCommand robotCommand = (RobotCommand) command;
        return robotCommand.isValid(dimension);
    }
}
