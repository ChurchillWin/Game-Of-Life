package testing;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        Board board = new Board(30);
        /*board.getCell(6,6).ressurect();
        board.getCell(5,6).ressurect();
        board.getCell(6,5).ressurect();
        board.getCell(6,4).ressurect();
        board.getCell(7,5).ressurect();*/

        /*board.getCell(5,5).ressurect();
        board.getCell(5,4).ressurect();
        board.getCell(5,6).ressurect();*/ //spinner

        board.getCell(14,14).ressurect();
        board.getCell(14,15).ressurect();
        board.getCell(15,15).ressurect();
        board.getCell(15,19).ressurect();
        board.getCell(15,20).ressurect();
        board.getCell(15,21).ressurect();
        board.getCell(13,20).ressurect();


        while (true) {

            board.gameOfLife();
        }
    }


}
