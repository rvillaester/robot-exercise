# The Problem
The application is a simulation of a robot moving on a rectangular table top. There are no other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.

## Commands
- **PLACE** X,Y,F (e.g PLACE 1,2,NORTH)
    - will put the robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST
- **MOVE**
    - will move the robot one unit forward in the direction it is currently facing
- **LEFT**
    - will rotate the robot 90 degrees in the specified direction without changing the position of the robot
- **RIGHT**
    - will rotate the robot 90 degrees in the specified direction without changing the position of the robot
- **REPORT**
    - will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient. A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands

## Constraints
- The origin (0,0) can be considered to be the SOUTH WEST most corner. It is required that the first command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command.
- The robot must not fall off the table during movement. This also includes the initial placement of the robot. Any move that would cause the robot to fall must be ignored.

# Running The Application
There are multiple ways to run the application. There are sample command instructions included in the package - refer to the instructions folder.

###### Preparations
1. It uses 5 by 5 rectangular table dimension by default. You can change this configuration in **table.properties** file
2. Create a file with **.rc** extension and put it under **instructions** folder.
3. Each of these files contains list of commands that the robot will execute
4. One command per line
5. The filename sans the extension will be the robot name. This is to distinguish which robot execute which command.
    - format will be **robot_name**.rc
    - e.g rey.rc
    - rey will be the robot name

###### Pre-requisites
1. Maven
2. Java 8 and above
3. GIT (most of the IDEs has this plugin by default)

## Run in your favorite IDE
You can use whatever IDE you're comfortable with. I'm using Eclipse and IntelliJ. By default, the output will be on a file called output.log. Modify root logger in log4j2.xml if you want switch to console logging.
1. Open your favorite IDE
2. Checkout the source code in this repository
3. Run Main.java

## Packaging The Application
Package the application so that we can use or run it anywhere.
1. Run **mvn clean package** against **pom.xml**
2. You will see the robot-exercise-**version**-distribution.zip under **target** directory
3. Unzip that file. It includes the following files:
    - instructions
        - this will contain all the **.rc** files
        - you can add more files or remove the existing files
    - lib
        - contains the project dependencies
        - no need to touch this folder
    - robot-exercise-**version**.jar
        - this is an executable jar
        - double click to run
    - output.log
        - this file will be created once you've run the jar file
        - this will contain the run outputs