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
    private Hero character;
    private int x = 10;
    private int y = 10;


    Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        this.character = new Hero(10,10);
    }

    private void draw() throws IOException{
        screen.clear();
        this.character.draw(screen);
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

    private void moveHero(Position pos){
        this.character.setPosition(pos);
    }
    private void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType())
        {
            case ArrowUp:
                moveHero(character.moveUp());
                break;
            case ArrowDown:
                moveHero(character.moveDown());
                break;
            case ArrowLeft:
                moveHero(character.moveLeft());
                break;
            case ArrowRight:
                moveHero(character.moveRight());
                break;
            case Character:
                if(key.getCharacter() == 'q')
                    screen.close();
                break;
        }
        this.draw();
    }
}
