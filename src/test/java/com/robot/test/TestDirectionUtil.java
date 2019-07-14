package com.robot.test;

import com.robot.Direction;
import com.robot.util.DirectionUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDirectionUtil {

    @Test
    public void canGetNextDirectionToTheRight(){
        assertEquals(Direction.NORTH, DirectionUtil.nextDirectionToTheRight(Direction.WEST));
        assertEquals(Direction.EAST, DirectionUtil.nextDirectionToTheRight(Direction.NORTH));
        assertEquals(Direction.SOUTH, DirectionUtil.nextDirectionToTheRight(Direction.EAST));
        assertEquals(Direction.WEST, DirectionUtil.nextDirectionToTheRight(Direction.SOUTH));
    }

    @Test
    public void canGetNextDirectionToTheLeft(){
        assertEquals(Direction.SOUTH, DirectionUtil.nextDirectionToTheLeft(Direction.WEST));
        assertEquals(Direction.EAST, DirectionUtil.nextDirectionToTheLeft(Direction.SOUTH));
        assertEquals(Direction.NORTH, DirectionUtil.nextDirectionToTheLeft(Direction.EAST));
        assertEquals(Direction.WEST, DirectionUtil.nextDirectionToTheLeft(Direction.NORTH));
    }

}
