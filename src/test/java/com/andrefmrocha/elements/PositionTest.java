package com.andrefmrocha.elements;

import org.junit.Test;
import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void movement(){
        Position pos =  new Position(1, 1);
        Position movUp = new Position(1, 0);
        Position movLeft = new Position(0, 1);
        Position movRight = new Position(2, 1);
        Position movDown = new Position(1, 2);
        assertEquals(movUp, pos.moveUp());
        assertEquals(movDown, pos.moveDown());
        assertEquals(movLeft, pos.moveLeft());
        assertEquals(movRight, pos.moveRight());
    }
}
