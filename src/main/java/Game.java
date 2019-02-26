import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private Arena arena;
    private Screen screen;
    private TextGraphics graphics;

    Game() throws IOException {
        arena = new Arena(50, 20);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();

        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        graphics = screen.newTextGraphics();
    }

    public void run() throws IOException {
        this.draw();
        KeyStroke key;
        do{
            key = screen.readInput();
            this.arena.processKey(key);
            this.draw();
            if(key.getKeyType() == KeyType.Character)
            {
                if(key.getCharacter() == 'q')
                    screen.close();
            }
        }while (key.getKeyType() != KeyType.EOF);
    }

    private void draw() throws IOException{
        screen.clear();
        this.arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

}
