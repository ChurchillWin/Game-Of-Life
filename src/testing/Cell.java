package testing;

public class Cell {
    private final int x, y;

    private boolean alive;
    private boolean isAliveFlag;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
        alive = false;
    }
    public int getX() {
        return x;
    }
    public void setFlag(boolean isAlive) {
        isAliveFlag = isAlive;
    }
    public int getY() {
        return y;
    }
    public boolean isAlive() {
        return alive;
    }
    public void ressurect() {
        alive = true;
    }
    public void die() {
        alive = false;
    }

    public void evolve() {
        if (isAliveFlag)
            this.ressurect();
        else
            this.die();
    }
}
