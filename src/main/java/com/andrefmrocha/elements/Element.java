package com.andrefmrocha.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element implements Drawable{
    protected Position pos;
    Element(int x, int y){
        this.pos = new Position(x, y);
    }

    public void draw(TextGraphics graphics){
        graphics.putString(new TerminalPosition(this.pos.getX(), this.pos.getY()), "X");
    }

    public int getX(){
        return this.pos.getX();
    }
    public int getY(){
        return this.pos.getY();
    }

    public boolean equals(Position pos) {
        return this.getX() == pos.getX() && this.getY() == pos.getY();
    }
}
