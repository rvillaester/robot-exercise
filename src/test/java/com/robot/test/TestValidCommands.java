package com.robot.test;

import com.robot.CommandStatus;
import com.robot.Direction;
import com.robot.Position;
import com.robot.command.*;
import com.robot.executor.RobotCommandExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidCommands {

    @Test
    public void executeCommandWhenRobotIsInTheTable(){
        RobotCommandExecutor executor = new RobotCommandExecutor();
        executor.executeCommand(new PlaceCommand(new Position(2,0, Direction.WEST)));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new LeftCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new RightCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new ReportCommand()));
    }

    @Test
    public void executeCommandWhenItDoesntCauseTheRobotToFall(){
        RobotCommandExecutor executor = new RobotCommandExecutor();
        executor.executeCommand(new PlaceCommand(new Position(2,0, Direction.WEST)));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new RightCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new RightCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new LeftCommand()));
        assertEquals(CommandStatus.VALID, executor.executeCommand(new MoveCommand()));
    }
}
