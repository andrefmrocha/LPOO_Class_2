import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int x;
    private int y;
    private TextCharacter character;


    Hero(int x, int y){
        this.x = x;
        this.y = y;
        this.character = new TextCharacter('X');
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp(){
        this.y-=1;
    }
    public void moveDown(){
        this.y+=1;
    }
    public void moveRight(){
        this.x+=1;
    }
    public void moveLeft(){
        this.y-=1;
    }
    public void draw(Screen screen){
        screen.setCharacter(this.x, this.y, character);
    }
}
