package com.robot.test;

import com.robot.Direction;
import com.robot.Position;
import com.robot.Robot;
import com.robot.command.LeftCommand;
import com.robot.command.MoveCommand;
import com.robot.command.PlaceCommand;
import com.robot.command.RightCommand;
import com.robot.executor.RobotCommandExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRobotCommands {

    @Test
    public void canMoveEastOnlyUntilTheEdgeOfTheTable(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(5,5, Direction.EAST)));
        for(int i=0; i<10; i++) {
            executor.executeCommand(new MoveCommand());
        }

        Position position = robot.getPosition();
        assertEquals(0, position.getX());
        assertEquals(5, position.getY());
    }

    @Test
    public void canMoveWestOnlyUntilTheEdgeOfTheTable(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(2,3, Direction.WEST)));
        for(int i=0; i<10; i++) {
            executor.executeCommand(new MoveCommand());
        }

        Position position = robot.getPosition();
        assertEquals(5, position.getX());
        assertEquals(3, position.getY());
    }

    @Test
    public void canMoveNorthOnlyUntilTheEdgeOfTheTable(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(1,4, Direction.NORTH)));
        for(int i=0; i<10; i++) {
            executor.executeCommand(new MoveCommand());
        }

        Position position = robot.getPosition();
        assertEquals(1, position.getX());
        assertEquals(5, position.getY());
    }

    @Test
    public void canMoveSouthOnlyUntilTheEdgeOfTheTable(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(4,2, Direction.SOUTH)));
        for(int i=0; i<10; i++) {
            executor.executeCommand(new MoveCommand());
        }

        Position position = robot.getPosition();
        assertEquals(4, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void canTurnRightMultipleTimesWithoutChangingItsLocation(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(4,2, Direction.SOUTH)));
        executor.executeCommand(new RightCommand());
        executor.executeCommand(new RightCommand());
        executor.executeCommand(new RightCommand());

        Position position = robot.getPosition();
        assertEquals(4, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Direction.EAST, position.getDirection());
    }

    @Test
    public void canTurnLeftMultipleTimesWithoutChangingItsLocation(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(1,3, Direction.WEST)));
        executor.executeCommand(new LeftCommand());
        executor.executeCommand(new LeftCommand());
        executor.executeCommand(new LeftCommand());
        executor.executeCommand(new LeftCommand());
        executor.executeCommand(new LeftCommand());

        Position position = robot.getPosition();
        assertEquals(1, position.getX());
        assertEquals(3, position.getY());
        assertEquals(Direction.SOUTH, position.getDirection());
    }

    @Test
    public void willOverrideTheCurrentRobotPositionWithThePlaceCommand(){
        Robot robot = new Robot("rey");
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(0,0, Direction.WEST)));
        executor.executeCommand(new RightCommand());
        executor.executeCommand(new MoveCommand());
        executor.executeCommand(new MoveCommand());

        Position position = robot.getPosition();
        assertEquals(0, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Direction.NORTH, position.getDirection());

        executor.executeCommand(new PlaceCommand(new Position(4,3, Direction.SOUTH)));

        position = robot.getPosition();
        assertEquals(4, position.getX());
        assertEquals(3, position.getY());
        assertEquals(Direction.SOUTH, position.getDirection());
    }
}
