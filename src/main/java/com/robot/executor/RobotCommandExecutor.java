package com.robot.executor;

import com.robot.CommandStatus;
import com.robot.RectangularTableDimension;
import com.robot.Robot;
import com.robot.command.RobotCommand;
import com.robot.validator.CommandValidator;
import com.robot.validator.RobotCommandValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RobotCommandExecutor {

    private CommandValidator commandValidator;
    private Robot robot;

    public RobotCommandExecutor(){
        this(new RectangularTableDimension(5));
    }

    public RobotCommandExecutor(RectangularTableDimension tableDimension){
        this(new Robot(), tableDimension);
    }

    public RobotCommandExecutor(Robot robot){
        this(robot, new RectangularTableDimension(5));
    }

    public RobotCommandExecutor(Robot robot, RectangularTableDimension tableDimension){
        this.commandValidator = new RobotCommandValidator(tableDimension);
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
        return isValid ? CommandStatus.VALID : CommandStatus.IGNORED;
    }
}
