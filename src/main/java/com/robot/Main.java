package com.robot;

public class Main {

    public static void main(String[] args) {
//        a();
        b();
    }

    static void a(){
        Robot robot = new Robot();
        RobotCommandExecutor executor = new RobotCommandExecutor(robot, 5);

        executor.executeCommand(new PlaceCommand(robot, new Position(0,0,Direction.EAST)));
        executor.executeCommand(new ReportCommand(robot));
        executor.executeCommand(new MoveCommand(robot));
        executor.executeCommand(new ReportCommand(robot));
        executor.executeCommand(new LeftCommand(robot));
        executor.executeCommand(new ReportCommand(robot));
        executor.executeCommand(new MoveCommand(robot));
        executor.executeCommand(new ReportCommand(robot));
        executor.executeCommand(new LeftCommand(robot));
        executor.executeCommand(new ReportCommand(robot));
        executor.executeCommand(new MoveCommand(robot));
        executor.executeCommand(new ReportCommand(robot));
    }

    static void b(){
        Robot robot = new Robot();
        RobotCommandExecutor executor = new RobotCommandExecutor(robot);
        executor.executeCommand(new PlaceCommand(new Position(0,0,Direction.EAST)));
        executor.executeCommand(new ReportCommand());
        executor.executeCommand(new MoveCommand());
        executor.executeCommand(new ReportCommand());
        executor.executeCommand(new LeftCommand());
        executor.executeCommand(new ReportCommand());
        executor.executeCommand(new MoveCommand());
        executor.executeCommand(new ReportCommand());
        executor.executeCommand(new LeftCommand());
        executor.executeCommand(new ReportCommand());
        executor.executeCommand(new MoveCommand());
        executor.executeCommand(new ReportCommand());
    }

}
