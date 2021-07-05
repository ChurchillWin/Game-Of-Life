package testing;

import java.util.Random;

public class Board {
    Random random = new Random();
    private int size;
    private char[][] board;
    public static Cell[][] cells;

    Board(int size) {
        this.size = size;
        board = new char[size][size];
        cells = new Cell[size][size];
        initializeCells();
    }
    private void initializeCells() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y] = new Cell(x, y, this);
            }
        }
    }

    public int getNeighbours(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int n = 0;
        //Sides
        if (x - 1 >= 0 && getCell(x - 1, y).isAlive()){ //left
            n++;
            if (y - 1 >= 0 && getCell(x - 1, y - 1).isAlive())//top left
                n++;
        }
        if (y - 1 >= 0 && getCell(x, y - 1).isAlive()){//top
            n++;
            if (x + 1 < size && getCell(x + 1, y - 1).isAlive())//top right
                n++;
        }
        if (x + 1 < size && getCell(x + 1, y).isAlive()) {//right
            n++;
            if (y + 1 < size && getCell(x + 1, y + 1).isAlive())//bottom right
                n++;
        }
        if (y + 1 < size && getCell(x, y + 1).isAlive()){//bottom
            n++;
            if (x - 1 >= 0 && getCell(x - 1, y + 1).isAlive())//bottom left
                n++;
        }

        return n;
    }

    public Cell getCell(int x, int y) {
        if(x < cells[0].length && y < size){
            return cells[x][y];
        }
        else
            return null;
    }

    public void gameOfLife() {
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

        System.out.printf("\n");
        renderBoard();
        System.out.printf("\n");

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y].evolve();
            }
        }
    }

    private void renderBoard() {
        String aliveCell = " + ";
        String deadCell = " - ";
        try {
            long secondsToSleep = 2;
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isAlive())
                    System.out.print(aliveCell);
                else
                    System.out.print(deadCell);
            }
        }
    }
}
