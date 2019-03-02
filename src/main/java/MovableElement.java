public class MovableElement extends Element {
    MovableElement(int x, int y){
        super(x, y);
    }

    public Position moveUp(){
        return this.pos.moveUp();
    }

    public Position moveDown(){
        return this.pos.moveDown();
    }
    public Position moveRight(){
        return this.pos.moveRight();
    }
    public Position moveLeft(){
        return this.pos.moveLeft();
    }

    public void setPosition(Position pos){
        this.pos = pos;
    }
}
