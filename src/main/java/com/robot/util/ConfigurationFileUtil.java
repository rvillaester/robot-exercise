package com.robot.util;

import com.robot.*;
import com.robot.command.PlaceCommand;
import com.robot.command.RobotCommand;
import com.robot.factory.RobotCommandFactory;
import com.robot.validator.InstructionValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Slf4j
public class ConfigurationFileUtil {

    private static final String COMMAND_EXT = ".rc";
    private static final String TABLE_PROPERTIES = "table.properties";
    private static final String INSTRUCTIONS_FOLDER = "instructions";

    public static RectangularTableDimension extractTableDimension(){
        InputStream input = ConfigurationFileUtil.class.getClassLoader().getResourceAsStream(TABLE_PROPERTIES);
        RectangularTableDimension tableDimension = new RectangularTableDimension(5);
        if(input == null){
            log.debug(String.format("Unable to find %s", TABLE_PROPERTIES));
        }else{
            Properties prop = new Properties();
            try {
                prop.load(input);
                tableDimension.setLength(Integer.valueOf(prop.getProperty("length")));
                tableDimension.setWidth(Integer.valueOf(prop.getProperty("width")));
            } catch (Exception e) {
                /**
                 * catch all types of exceptions and log it
                 * if this happens, it will use the default table dimension
                 */
                log.warn(String.format("Error in loading %s", TABLE_PROPERTIES), e);
            }
        }
        return tableDimension;
    }

    public static List<RobotInstructions> extractRobotInstructions(){
        List<RobotInstructions> instructions = new ArrayList<>();
        File folder = new File(INSTRUCTIONS_FOLDER);
        File[] listOfFiles = folder.listFiles();
        Arrays.stream(listOfFiles)
                .filter(f -> (f.isFile() && f.getName().endsWith(COMMAND_EXT)))
                .forEach(f -> {
                    String name = f.getName().replace(COMMAND_EXT, "");
                    try {
                        RobotInstructions inst = new RobotInstructions(new Robot(name));
                        inst.setCommands(extractCommands(f));
                        instructions.add(inst);
                    } catch (IOException e) {
                        /**
                         * disregard when issue encounter on reading a particular file
                         * we'll skip it and move to the next file
                         */
                        log.warn(String.format("Error in reading file %s", name), e);
                    }
                });
        return instructions;
    }

    private static List<RobotCommand> extractCommands(File file) throws IOException {
        List<RobotCommand> commands = new ArrayList<>();
        InstructionValidator validator = new InstructionValidator();
        RobotCommandFactory factory = new RobotCommandFactory();
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        lines.stream().forEach(line -> {
            if(validator.validate(line)) {
                String[] strs = line.toUpperCase().trim().split(" ");
                RobotCommand robotCommand = factory.getCommand(strs[0]);
                if (robotCommand instanceof PlaceCommand) {
                    PlaceCommand placeCommand = (PlaceCommand) robotCommand;
                    placeCommand.setPosition(getPosition(strs[1]));
                }
                commands.add(robotCommand);
            }
        });
        return commands;
    }

    private static Position getPosition(String str){
        String[] params = str.split(",");
        int x = Integer.valueOf(params[0]);
        int y = Integer.valueOf(params[1]);
        Direction direction = Direction.getDirection(params[2]);
        return new Position(x,y,direction);
    }
}
