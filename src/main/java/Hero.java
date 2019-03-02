import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends MovableElement{
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


    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        super.draw(graphics, "T");
    }
}
