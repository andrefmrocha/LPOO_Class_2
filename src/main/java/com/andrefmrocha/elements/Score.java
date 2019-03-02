package com.andrefmrocha.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Score extends Element{
    private int score = 0;
    public Score(int x, int y){
        super(x, y);
    }

    public int scored(){
        return ++this.score;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        super.draw(graphics, "Score: " + score);

    }
}
