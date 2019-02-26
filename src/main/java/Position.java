public class Position {
    private int x;
    private int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
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

    public Position moveUp(){
        return new Position(this.getX(), this.getY() - 1);
    }
    public Position moveDown(){
        return new Position(this.getX(), this.getY() + 1);
    }
    public Position moveRight(){
        return new Position(this.getX() + 1, this.getY());
    }
    public Position moveLeft(){
        return new Position(this.getX()- 1, this.getY() - 1);
    }

}
