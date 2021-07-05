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
        for (int x = 0; x < cells[0].length; x++) {
            for (int y = 0; y < cells[1].length; y++) {
                cells[x][y] = new Cell(x, y, this);
            }
        }
    }

    public int getNeighbours(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        int n = 0;
            if (x - 1 >= 0 && y - 1 >= 0) {
                if (x < cells[0].length && y < cells[1].length) {
                    if(getCell(x-1, y).isAlive())
                        n++;
                    if(getCell(x+1, y).isAlive())
                        n++;
                    if(getCell(x, y-1).isAlive())
                        n++;
                    if(getCell(x+1, y).isAlive())
                        n++;
                }
            }
        return n;
    }

    public Cell getCell(int x, int y) {
        if(x < cells[0].length && y < cells[1].length){
            return cells[x][y];
        }
        else
            return null;
    }

    public void gameOfLife() {
        for (int x = 0; x < cells[0].length; x++) {
            for (int y = 0; y < cells[1].length; y++) {
                if (getCell(x, y).isAlive()){
                    if (getNeighbours(cells[x][y]) < 2 || getNeighbours(cells[x][y]) > 3) {
                        cells[x][y].die();
                    }
                }else if (getNeighbours(cells[x][y]) == 3) {
                    cells[x][y].ressurect();
                }
            }
        }
    }

    public void renderBoard() {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                if (i % 3 == 0 || j % 3 == 0) {
                    board[i][j] = '0';
                }else board[i][j] = '#';

            }
        }
        for (int i = 0; i < board[0].length; i++) {
            System.out.println();
            for (int j = 0; j < board[1].length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
        }
    }
}
