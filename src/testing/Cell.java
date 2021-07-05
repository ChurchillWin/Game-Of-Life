package testing;

public class Cell {
    private int x, y, neighbours = 0;
    Board board;
    private boolean alive;
    Cell(int x, int y, Board board){
        this.board = board;
        this.x = x;
        this.y = y;
        alive = false;
    }
    public int getX() {
        return x;
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

    private void setNeighbors() {
        neighbours = board.getNeighbours(this);
    }

}
