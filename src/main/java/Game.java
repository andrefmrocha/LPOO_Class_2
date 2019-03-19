import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private GameWorld gameWorld;
    private Screen screen;

    Game() throws IOException {
        gameWorld = new Arena(50, 20);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();

        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public void run() throws IOException, InterruptedException {
        this.draw();
        KeyStroke key;
        try{
            do{
                key = screen.readInput();
                this.gameWorld.processKey(key);
                this.draw();
                if(key.getKeyType() == KeyType.Character)
                {
                    if(key.getCharacter() == 'q')
                        screen.close();
                }
            }while (key.getKeyType() != KeyType.EOF);
        } catch (GameException e){
            System.out.println(e.message());
            Thread.sleep(3000);
            screen.close();
        }
    }

    private void draw() throws IOException{
        screen.clear();
        this.gameWorld.draw(screen.newTextGraphics());
        screen.refresh();
    }

}
