import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{
    Hero(int x, int y){
        super(x, y);
    }
    public int getX() {
        return this.pos.getX();
    }

    public void setX(int x) {
        this.pos.setX(x);
    }

    public int getY() {
        return this.pos.getY();
    }

    public void setY(int y) {
        this.pos.setY(y);
    }

    public Position moveUp(){
        return this.pos.moveUp();
    }

    public Position moveDown(){
        return this.pos.moveDown();
    }
    public Position moveRight(){
        return this.pos.moveRight();
    }
    public Position moveLeft(){
        return this.pos.moveLeft();
    }

    public void setPosition(Position pos){
        this.pos = pos;
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        super.draw(graphics);
    }
}
