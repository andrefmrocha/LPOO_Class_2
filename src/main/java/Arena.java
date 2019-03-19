import com.andrefmrocha.elements.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Arena implements GameWorld{
    private int width;
    private int counter;
    private int height;
    private Hero character;
    private List<Drawable> drawings;
    private Score score;
    private int maxCoins = 5;

    Arena(int width, int height){
        this.width = width;
        this.height = height;
        this.character = new Hero(10,10);
        this.drawings = new ArrayList<>();
        this.createWalls();
        this.createCoins();
        this.counter = 0;
        this.score = new Score(10, 25);
    }

    private boolean canObjectMove(Position pos){
        return pos.getX() >= 1 && pos.getX() < width - 1 && pos.getY() >= 1 && pos.getY() < height - 1;
    }

    private void checkCoins(Position pos) throws Finish {
        for(Drawable drawing: this.drawings){
            if(drawing.getClass().equals(Coin.class)){
                Coin coin = (Coin) drawing;
                if(coin.equals(pos))
                {
                    this.drawings.remove(coin);
                    if(this.score.scored() == this.maxCoins)
                        throw new Finish();
                    break;
                }
            }

        }
    }

    private void moveHero(Position pos) throws Finish {
        if(this.canObjectMove(pos))
        {
            this.checkCoins(pos);
            this.character.setPosition(pos);
        }
    }

    private void verifyMonsterCollisions(Position pos) throws Collision {
        if(this.character.equals(pos)){
            System.out.println("com.andrefmrocha.elements.Monster: " +  pos.getX() + pos.getY());
            throw new Collision();
        }
    }

    private void moveMonster(Monster monster, Position pos) throws Collision {
        verifyMonsterCollisions(pos);
        monster.setPosition(pos);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#11051b"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for(Drawable drawing: this.drawings)
            drawing.draw(graphics);
        this.character.draw(graphics);
        this.score.draw(graphics);
    }


    private void createCoins(){
        Random random = new Random();
        for (int i = 0; i < this.maxCoins; i++)
            drawings.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
    }

    private void createMonster(){
        Random random = new Random();
        this.drawings.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
    }

    private void moveMonsters() throws Collision {
        Iterator<Drawable> it= this.drawings.iterator();
        while (it.hasNext()){
            Drawable drawable = it.next();
            if(drawable.getClass().equals(Monster.class))
            {
                Monster monster = (Monster) drawable;
                if(this.canObjectMove(monster.move())){
                    moveMonster(monster, monster.move());
                }else
                    it.remove();
            }
        }
    }

    public void processKey(KeyStroke key) throws GameException{
        this.counter++;
        if(this.counter % 5 == 0){
            this.counter = 0;
            this.createMonster();
        }
        this.moveMonsters();
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

    private void createWalls(){
        for(int c = 0; c < width; c++){
            drawings.add(new Wall(c, 0));
            drawings.add(new Wall(c, this.height - 1));
        }
        for(int w = 0; w < height - 1; w++){
            drawings.add(new Wall(0, w));
            drawings.add(new Wall(this.width - 1, w));
        }
    }

}
