import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element {
    protected Position pos;
    Element(int x, int y){
        this.pos = new Position(x, y);
    }

    protected  void draw(TextGraphics graphics){
        graphics.putString(new TerminalPosition(this.pos.getX(), this.pos.getY()), "X");
    }
}
