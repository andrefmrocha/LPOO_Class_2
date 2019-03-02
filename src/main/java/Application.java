import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try{
            Game game = new Game();
            game.run();
        }catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
