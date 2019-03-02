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

public class Arena {
    private int width;
    private int counter;
    private int height;
    private Hero character;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Arena(int width, int height){
        this.width = width;
        this.height = height;
        this.character = new Hero(10,10);
        this.walls = createWalls();
        this.coins = this.createCoins();
        this.monsters = new ArrayList<>();
        this.counter = 0;
    }

    private boolean canObjectMove(Position pos){
        return pos.getX() >= 1 && pos.getX() < width - 1 && pos.getY() >= 1 && pos.getY() < height - 1;
    }

    private void checkCoins(Position pos){
        for(Coin coin: this.coins){
            if(coin.equals(pos))
            {
                this.coins.remove(coin);
                break;
            }

        }
    }

    private void moveHero(Position pos){
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

    protected void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#11051b"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for(Wall wall: this.walls)
            wall.draw(graphics);
        for(Coin coin: this.coins)
            coin.draw(graphics);
        for(Monster monster: this.monsters)
            monster.draw(graphics);
        this.character.draw(graphics);
    }


    private List<Coin> createCoins(){
        Random random = new Random();
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private void createMonster(){
        Random random = new Random();
        this.monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
    }

    private void moveMonsters() throws Collision {
        Iterator<Monster> it= this.monsters.iterator();
        while (it.hasNext()){
            Monster monster = it.next();
            if(this.canObjectMove(monster.move())){
                moveMonster(monster, monster.move());
            }else
                it.remove();
        }
    }

    protected void processKey(KeyStroke key) throws Collision {
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
