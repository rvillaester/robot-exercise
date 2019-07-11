package com.robot.test;

import com.robot.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInvalidCommands {

    @Test
    public void ignoreCommandWhenRobotIsNotInTable(){
        RobotCommandExecutor executor = new RobotCommandExecutor();
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new LeftCommand()));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new RightCommand()));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new ReportCommand()));
    }

    @Test
    public void ignoreMoveCommandWhenItCausesTheRobotToFallInTheTable(){
        RobotCommandExecutor executor = new RobotCommandExecutor();

        executor.executeCommand(new PlaceCommand(new Position(0,0, Direction.EAST)));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new RightCommand());
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));

        executor.executeCommand(new PlaceCommand(new Position(0,5, Direction.NORTH)));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new RightCommand());
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));

        executor.executeCommand(new PlaceCommand(new Position(5,0, Direction.WEST)));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new LeftCommand());
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));

        executor.executeCommand(new PlaceCommand(new Position(5,5, Direction.NORTH)));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));
        executor.executeCommand(new LeftCommand());
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new MoveCommand()));
    }

    @Test
    public void cannotPlaceRobotOutsideTableDimension(){
        RobotCommandExecutor executor = new RobotCommandExecutor();
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new PlaceCommand(new Position(789,4, Direction.WEST))));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new PlaceCommand(new Position(6,6, Direction.WEST))));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new PlaceCommand(new Position(3,78, Direction.WEST))));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new PlaceCommand(new Position(6,-3, Direction.WEST))));
        assertEquals(CommandStatus.INVALID, executor.executeCommand(new PlaceCommand(new Position(-1,0, Direction.WEST))));
    }
}
