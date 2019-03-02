package com.andrefmrocha.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends MovableElement {
    private int monsterType;
    public Monster(int x, int y){
        super(x, y);
        Random rand = new Random();
        this.monsterType = rand.nextInt(4) + 1;
        System.out.println(this.monsterType);
    }

    public Position move(){
        switch (monsterType){
            case 1:
                return this.moveUp();

            case 2:
                return this.moveDown();

            case 3:
                return this.moveRight();

            case 4:
                return this.moveLeft();
            default:
                return null;
        }
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#DC143C"));
        graphics.enableModifiers(SGR.BOLD);
        switch (this.monsterType){
            case 1:
                this.draw(graphics, "U");
                break;

            case 2:
                this.draw(graphics, "D");
                break;

            case 3:
                this.draw(graphics, "R");
                break;

            case 4:
               this.draw(graphics, "L");
                break;

        }
    }
}
