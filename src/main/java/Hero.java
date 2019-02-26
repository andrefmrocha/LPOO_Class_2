import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private TextCharacter character;
    private Position pos;


    Hero(int x, int y){
        this.pos = new Position(x, y);
        this.character = new TextCharacter('X');

    }
    public int getX() {
        return this.pos.getX();
    }

    public void setX(int x) {
        this.pos.setX(x);
    }

    public int getY() {
        return this.pos.getY();
    }

    public void setY(int y) {
        this.pos.setY(y);
    }

    public void moveUp(){
        this.pos.moveUp();
    }

    public void moveDown(){
        this.pos.moveDown();
    }
    public void moveRight(){
        this.pos.moveRight();
    }
    public void moveLeft(){
        this.pos.moveLeft();
    }
    public void draw(Screen screen){
        screen.setCharacter(this.getX(), this.getY(), character);
    }
}
