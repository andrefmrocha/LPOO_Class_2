import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero character;
    private List<Wall> walls;

    Arena(int width, int height){
        this.width = width;
        this.height = height;
        this.character = new Hero(10,10);
        this.walls = createWalls();
    }

    private boolean canHeroMove(Position pos){
        return pos.getX() >= 1 && pos.getX() < width - 1 && pos.getY() >= 1 && pos.getY() < height - 1;
    }

    private void moveHero(Position pos){
        if(this.canHeroMove(pos))
            this.character.setPosition(pos);
    }

    protected void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#11051b"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for(Wall wall: this.walls)
            wall.draw(graphics);
        this.character.draw(graphics);
    }


    protected void processKey(KeyStroke key) {
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
        }
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();
        for(int c = 0; c < width; c++){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, this.height - 1));
        }
        for(int w = 0; w < height - 1; w++){
            walls.add(new Wall(0, w));
            walls.add(new Wall(this.width - 1, w));
        }
        return walls;
    }

}
