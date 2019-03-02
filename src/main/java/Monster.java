import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends MovableElement {
    Monster(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#DC143C"));
        graphics.enableModifiers(SGR.BOLD);
        super.draw(graphics, "H");
    }
}
