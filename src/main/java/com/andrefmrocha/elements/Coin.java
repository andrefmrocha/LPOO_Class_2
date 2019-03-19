package com.andrefmrocha.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {
    public Coin(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        super.draw(graphics, "O", new TerminalPosition(this.pos.getX(), this.pos.getY()));
    }
}
