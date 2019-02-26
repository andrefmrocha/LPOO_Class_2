import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.ArrowUp;

public class Game {
    private Screen screen;
    private TextCharacter character;
    private int x = 10;
    private int y = 10;


    Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        this.character = new TextCharacter('X');
    }

    private void draw() throws IOException{
        screen.clear();
        screen.setCharacter(x, y, this.character);
        screen.refresh();
    }

    public void run() throws IOException {
        this.draw();
        KeyStroke key;
        do{
            key = screen.readInput();
            this.processKey(key);

        }while (key.getKeyType() != KeyType.EOF);
        this.processKey(key);
    }

    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType())
        {
            case ArrowUp:
                this.y-=1;
                break;
            case ArrowDown:
                this.y+=1;
                break;
            case ArrowLeft:
                this.x-=1;
                break;
            case ArrowRight:
                this.x+=1;
                break;
            case Character:
                if(key.getCharacter() == 'q')
                    screen.close();
                break;
        }
        this.draw();
    }
}
