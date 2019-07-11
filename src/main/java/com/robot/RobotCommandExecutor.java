package com.robot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RobotCommandExecutor {

    private CommandValidator commandValidator;
    private Robot robot;

    public RobotCommandExecutor(){
        this(5);
    }

    public RobotCommandExecutor(int dimension){
        this(new Robot(), 5);
    }

    public RobotCommandExecutor(Robot robot){
        this(robot, 5);
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
        return isValid ? CommandStatus.VALID : CommandStatus.INVALID;
    }

}
