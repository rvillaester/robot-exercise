package com.robot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RobotCommandExecutor {

    private CommandValidator commandValidator;
    private Robot robot;

    public RobotCommandExecutor(){
        this.commandValidator = new RobotCommandValidator(5);
    }

    public RobotCommandExecutor(int dimension){
        this.commandValidator = new RobotCommandValidator(dimension);
    }

    public RobotCommandExecutor(Robot robot){
        this.commandValidator = new RobotCommandValidator(5);
        this.robot = robot;
    }

    public RobotCommandExecutor(Robot robot, int dimension){
        this.commandValidator = new RobotCommandValidator(dimension);
        this.robot = robot;
    }

    public CommandStatus executeCommand(RobotCommand command){
        command.executeOn(robot);
        boolean isValid = this.commandValidator.validate(command);
        if(isValid) {
            command.execute();
        }else{
            log.debug(String.format("Invalid command: %s", command));
        }
        return isValid ? CommandStatus.SUCCESS : CommandStatus.FAIL;
    }



}
