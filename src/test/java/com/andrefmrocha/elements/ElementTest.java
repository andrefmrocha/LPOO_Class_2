package com.andrefmrocha.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class ElementTest {
    Element elem;
    @Before
    public void initializeElement(){
        this.elem = new Element(0, 0);
    }

    @Test
    public void draw(){
        TextGraphics mockGraphics = Mockito.mock(TextGraphics.class);
        TerminalPosition pos = Mockito.mock(TerminalPosition.class);
//        Position pos = new Position(1, 2);
        Mockito.when(mockGraphics.putString(any(TerminalPosition.class), any(String.class))).thenReturn((TextGraphics) returnsFirstArg());

    }
}
