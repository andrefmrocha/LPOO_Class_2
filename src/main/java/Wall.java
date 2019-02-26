import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    Wall(int x, int y){
        super(x, y);
    }

    protected void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#C71585"));
        super.draw(graphics);
    }

}
