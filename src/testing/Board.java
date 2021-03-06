package testing;

import java.util.Random;

public class Board {
    Random random = new Random();
    private final int size;
    private final Cell[][] cells;

    final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_WHITE = "\u001B[37m";
    final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeCells();
    }
    private void initializeCells() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }
    public int getSize() {
        return size;
    }
    public int getNeighbours(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int n = 0;
        //Sides
        if (x - 1 >= 0 && getCell(x - 1, y).isAlive()) //left
            n++;
        if (y - 1 >= 0 && getCell(x - 1, y - 1).isAlive())//top left
            n++;
        if (y - 1 >= 0 && getCell(x, y - 1).isAlive())//top
            n++;
        if (x + 1 < size && getCell(x + 1, y - 1).isAlive())//top right
            n++;
        if (x + 1 < size && getCell(x + 1, y).isAlive()) //right
            n++;
        if (y + 1 < size && getCell(x + 1, y + 1).isAlive())//bottom right
            n++;
        if (y + 1 < size && getCell(x, y + 1).isAlive())//bottom
            n++;
        if (x - 1 >= 0 && getCell(x - 1, y + 1).isAlive())//bottom left
            n++;


        return n;
    }

    public Cell getCell(int x, int y) {
        if(x < size && y < size){
            if (x >= 0 && y >= 0)
                return cells[x][y];
            return new Cell(0, 0);
        }
        else
            return new Cell(0, 0);
    }

    public void gameOfLife() {
        System.out.print("\n" + ANSI_RESET);
        renderBoard();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (getCell(x, y).isAlive()){
                    if (getNeighbours(cells[x][y]) == 2 || getNeighbours(cells[x][y]) == 3) {
                        cells[x][y].setFlag(true);
                    }else
                        cells[x][y].setFlag(false);
                }else if (getNeighbours(cells[x][y]) == 3) {
                    cells[x][y].setFlag(true);
                }
            }
        }
        //update flags
        for (Cell[] cArr: cells) {
            for (Cell c: cArr){
                c.evolve();
            }
        }
    }

    public void populateRandom() {
        for (int i = 0; i < size * (size / 2); i++) {
            this.getCell(random.nextInt(size - 3), random.nextInt(size - 3)).ressurect();
        }
    }

    private void renderBoard() {
        String aliveCell = " 0 ";
        String deadCell = " = ";
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            System.out.print("\n");
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isAlive())
                    System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND + aliveCell + ANSI_RESET);
                else
                    System.out.print( ANSI_WHITE + ANSI_BLACK_BACKGROUND + deadCell + ANSI_RESET);
            }
        }
    }
}
