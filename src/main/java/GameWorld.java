import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public interface GameWorld {
    void draw(TextGraphics graphics);
    void processKey(KeyStroke key) throws GameException;
}
