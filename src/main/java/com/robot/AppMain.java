package com.robot;

import com.robot.command.RobotCommand;
import com.robot.executor.RobotCommandExecutor;
import com.robot.util.ConfigurationFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AppMain {

    public static void main(String[] args) {
        RectangularTableDimension tableDimension = ConfigurationFileUtil.extractTableDimension();
        List<RobotInstructions> instructions = ConfigurationFileUtil.extractRobotInstructions();
        instructions.stream().forEach(instruction -> {
                    Robot robot = instruction.getRobot();
                    RobotCommandExecutor commandExecutor = new RobotCommandExecutor(robot, tableDimension);
                    List<RobotCommand> commands = instruction.getCommands();
                    log.info(String.format("---- Outputs for %s ----", robot.getName()));
                    commands.stream().forEach(c -> commandExecutor.executeCommand(c));
                }
        );
    }
}
