package com.robot.test;

import com.robot.validator.InstructionValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestInstructionValidator {

    private InstructionValidator validator = new InstructionValidator();

    @Test
    public void validForCorrectLeftCommand(){
        assertTrue(validator.validate("Left"));
        assertTrue(validator.validate("Left "));
        assertTrue(validator.validate("LEFT "));
        assertTrue(validator.validate("LEFT"));
        assertTrue(validator.validate("  LEFT"));
    }

    @Test
    public void invalidForWrongLeftCommand(){
        assertFalse(validator.validate("Le ft"));
        assertFalse(validator.validate("Left turn"));
        assertFalse(validator.validate("Turn Left "));
        assertFalse(validator.validate("LEFT 1,2"));
        assertFalse(validator.validate("LEFT PLAce 2,3"));
        assertFalse(validator.validate("  LEFTist"));
    }

    @Test
    public void validForCorrectRightCommand(){
        assertTrue(validator.validate("Right"));
        assertTrue(validator.validate("  Right "));
        assertTrue(validator.validate("RiGht "));
        assertTrue(validator.validate("RIGHT"));
    }

    @Test
    public void invalidForWrongRightCommand(){
        assertFalse(validator.validate("Ri ght"));
        assertFalse(validator.validate("Right turn"));
        assertFalse(validator.validate("Turn Right "));
        assertFalse(validator.validate("RIGHT 1,2"));
        assertFalse(validator.validate("RIGHT PLAce 2,3"));
        assertFalse(validator.validate("  Right Move"));
    }

    @Test
    public void validForCorrectMoveCommand(){
        assertTrue(validator.validate("Move"));
        assertTrue(validator.validate("Move "));
        assertTrue(validator.validate("MoVE "));
        assertTrue(validator.validate("MOVE"));
        assertTrue(validator.validate("  MOVE"));
    }

    @Test
    public void invalidForWrongMoveCommand(){
        assertFalse(validator.validate("MO Ve"));
        assertFalse(validator.validate("Move right here"));
        assertFalse(validator.validate("Move Left "));
        assertFalse(validator.validate("Move 1,2"));
        assertFalse(validator.validate("Move to PLAce 2,3,NORTH"));
        assertFalse(validator.validate("  Movement"));
    }

    @Test
    public void validForCorrectReportCommand(){
        assertTrue(validator.validate("Report"));
        assertTrue(validator.validate("Report "));
        assertTrue(validator.validate("  RePOrt "));
        assertTrue(validator.validate("REPORT"));
        assertTrue(validator.validate("  REPORT  "));
    }

    @Test
    public void invalidForWrongReportCommand(){
        assertFalse(validator.validate("Re po rt"));
        assertFalse(validator.validate("Report here"));
        assertFalse(validator.validate(" Reported "));
        assertFalse(validator.validate("REPORT Spammer players"));
        assertFalse(validator.validate("REPORT ROBOT"));
        assertFalse(validator.validate("  REPORT ER"));
    }

    @Test
    public void validForCorrectPlaceCommand(){
        assertTrue(validator.validate("Place 1,2,NORTH"));
        assertTrue(validator.validate(" Place 0,5,South  "));
        assertTrue(validator.validate("PLACE 3,4,EAST"));
    }

    @Test
    public void invalidForPlaceCommandWithNegativePosition(){
        assertFalse(validator.validate("PLACE -2,0,EAST"));
        assertFalse(validator.validate("PLACE -2,-5,WEST"));
        assertFalse(validator.validate("PLACE 2,-4,NORTH"));
    }

    @Test
    public void invalidForPlaceCommandWithInvalidDirection(){
        assertFalse(validator.validate("PLACE 2,0,EASTERN"));
        assertFalse(validator.validate("PLACE 2,5,WESTCOAST"));
        assertFalse(validator.validate("PLACE 2,4,NORTHON"));
        assertFalse(validator.validate("PLACE 1,8,ZZZZ"));
    }

    @Test
    public void invalidForWrongPlaceCommand(){
        assertFalse(validator.validate("Place 1,2,NORTH EAST"));
        assertFalse(validator.validate("Places 1,2,SOUTH"));
        assertFalse(validator.validate("Place HERE 1,2,NORTH"));
        assertFalse(validator.validate("PLACE 1,2|SOUTH"));
        assertFalse(validator.validate("PLACE,1,2,SOUTH"));
        assertFalse(validator.validate("PLACE | 1,2,WEST"));
    }
}
