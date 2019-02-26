import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Screen screen;
    private Hero character;

    Arena(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        this.width = width;
        this.height = height;
        this.character = new Hero(10,10);
    }

    private boolean canHeroMove(Position pos){
        return pos.getX() >= 0 && pos.getX() <= width && pos.getY() >= 0 && pos.getY() <= height;
    }

    private void moveHero(Position pos){
        if(this.canHeroMove(pos))
            this.character.setPosition(pos);
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
