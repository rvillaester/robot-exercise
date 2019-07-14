package com.robot.test;

import com.robot.command.*;
import com.robot.factory.RobotCommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestRobotCommandFactory {

    private RobotCommandFactory factory = new RobotCommandFactory();

    @Test
    public void canCreateNewRobotCommandObjectWhenCommandKeywordIsValid(){
        assertTrue(factory.getCommand(LeftCommand.COMMAND) instanceof LeftCommand);
        assertTrue(factory.getCommand("leFt") instanceof LeftCommand);
        assertTrue(factory.getCommand("LeFt") instanceof LeftCommand);
        assertTrue(factory.getCommand(RightCommand.COMMAND) instanceof RightCommand);
        assertTrue(factory.getCommand("right") instanceof RightCommand);
        assertTrue(factory.getCommand("rigHT") instanceof RightCommand);
        assertTrue(factory.getCommand(MoveCommand.COMMAND) instanceof MoveCommand);
        assertTrue(factory.getCommand("MOVe") instanceof MoveCommand);
        assertTrue(factory.getCommand("MoVe") instanceof MoveCommand);
        assertTrue(factory.getCommand(PlaceCommand.COMMAND) instanceof PlaceCommand);
        assertTrue(factory.getCommand("pLaCE") instanceof PlaceCommand);
        assertTrue(factory.getCommand("PLaCE") instanceof PlaceCommand);
        assertTrue(factory.getCommand(ReportCommand.COMMAND) instanceof ReportCommand);
        assertTrue(factory.getCommand("Report") instanceof ReportCommand);
        assertTrue(factory.getCommand("rEPORT") instanceof ReportCommand);
    }

    @Test
    public void willReturnNulltWhenCommandKeywordIsInvalid(){
        assertNull(factory.getCommand("XXXX3243"));
        assertNull(factory.getCommand("REPORT12"));
        assertNull(factory.getCommand("LEft 3d"));
        assertNull(factory.getCommand("Invalid"));
        assertNull(factory.getCommand("Rights"));
        assertNull(factory.getCommand("Mo ve"));
        assertNull(factory.getCommand("Placement"));
    }
}
