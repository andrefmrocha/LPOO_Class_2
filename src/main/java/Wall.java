import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position pos;

    Wall(int x, int y){
        this.pos = new Position(x, y);
    }

    protected void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#C71585"));
        graphics.putString(new TerminalPosition(this.pos.getX(), this.pos.getY()), "X");
    }
}
