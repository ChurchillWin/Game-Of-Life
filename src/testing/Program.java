package testing;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        Board board = new Board(20);
        /*board.getCell(6,6).ressurect();
        board.getCell(5,6).ressurect();
        board.getCell(6,5).ressurect();
        board.getCell(6,4).ressurect();
        board.getCell(7,5).ressurect();*/

        board.getCell(5,5).ressurect();
        board.getCell(5,4).ressurect();
        board.getCell(5,6).ressurect();


        while (true) {

            board.gameOfLife();
        }
    }


}
