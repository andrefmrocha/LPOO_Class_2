import java.io.IOException;


public class Game {
    Arena arena;
    Game() throws IOException {
        arena = new Arena(50, 20);
    }

    public void run() throws IOException {
        arena.run();
    }

}
