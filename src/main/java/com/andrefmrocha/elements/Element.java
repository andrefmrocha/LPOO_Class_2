package com.andrefmrocha.elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element {
    protected Position pos;
    Element(int x, int y){
        this.pos = new Position(x, y);
    }

    protected  void draw(TextGraphics graphics, String character, TerminalPosition pos){
        graphics.putString(pos, character);
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
