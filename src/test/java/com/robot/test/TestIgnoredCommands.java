package com.robot.test;

import com.robot.*;
import com.robot.command.*;
import com.robot.executor.RobotCommandExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIgnoredCommands {

    @Test
    public void ignoreCommandWhenRobotIsNotInTable(){
        RobotCommandExecutor executor = new RobotCommandExecutor();
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new LeftCommand()));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new RightCommand()));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new ReportCommand()));
    }

    @Test
    public void ignoreMoveCommandWhenItCausesTheRobotToFallInTheTable(){
        RobotCommandExecutor executor = new RobotCommandExecutor();

        executor.executeCommand(new PlaceCommand(new Position(0,0, Direction.EAST)));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new RightCommand());
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));

        executor.executeCommand(new PlaceCommand(new Position(0,5, Direction.NORTH)));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new RightCommand());
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));

        executor.executeCommand(new PlaceCommand(new Position(5,0, Direction.WEST)));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new LeftCommand());
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));

        executor.executeCommand(new PlaceCommand(new Position(5,5, Direction.NORTH)));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new LeftCommand());
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new MoveCommand()));
    }

    @Test
    public void cannotPlaceRobotOutsideTableDimension(){
        RobotCommandExecutor executor = new RobotCommandExecutor();
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new PlaceCommand(new Position(789,4, Direction.WEST))));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new PlaceCommand(new Position(6,6, Direction.WEST))));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new PlaceCommand(new Position(3,78, Direction.WEST))));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new PlaceCommand(new Position(6,-3, Direction.WEST))));
        assertEquals(CommandStatus.IGNORED, executor.executeCommand(new PlaceCommand(new Position(-1,0, Direction.WEST))));
    }
}
