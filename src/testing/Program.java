package testing;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        Board board = new Board(51);
        /*board.getCell(6,6).ressurect();
        board.getCell(5,6).ressurect();
        board.getCell(6,5).ressurect();
        board.getCell(6,4).ressurect();
        board.getCell(7,5).ressurect();*/

        //Spinner
        /*board.getCell(5,5).ressurect();
        board.getCell(5,4).ressurect();
        board.getCell(5,6).ressurect();*/

        /*board.getCell(14,14).ressurect();
        board.getCell(14,15).ressurect();
        board.getCell(15,15).ressurect();
        board.getCell(15,19).ressurect();
        board.getCell(15,20).ressurect();
        board.getCell(15,21).ressurect();
        board.getCell(13,20).ressurect();*/

        board.populateRandom();


        //Glider
       /* board.getCell(15,13).ressurect();
        board.getCell(16,14).ressurect();
        board.getCell(17,14).ressurect();
        board.getCell(17,13).ressurect();
        board.getCell(17,12).ressurect();*/

        //Gun
        /*board.getCell(5,1).ressurect();
        board.getCell(5,2).ressurect();
        board.getCell(6,1).ressurect();
        board.getCell(6,2).ressurect();
        board.getCell(4,12).ressurect();
        board.getCell(5,11).ressurect();
        board.getCell(6,11).ressurect();
        board.getCell(7,11).ressurect();
        board.getCell(4,12).ressurect();
        board.getCell(3,13).ressurect();
        board.getCell(3,14).ressurect();
        board.getCell(8,12).ressurect();
        board.getCell(9,13).ressurect();
        board.getCell(9,14).ressurect();
        board.getCell(6,15).ressurect();
        board.getCell(4,16).ressurect();
        board.getCell(8,16).ressurect();
        board.getCell(5,17).ressurect();
        board.getCell(6,17).ressurect();
        board.getCell(7,17).ressurect();
        board.getCell(6,18).ressurect();

        board.getCell(3,21).ressurect();
        board.getCell(3,22).ressurect();
        board.getCell(4,21).ressurect();
        board.getCell(4,22).ressurect();
        board.getCell(5,21).ressurect();
        board.getCell(5,22).ressurect();

        board.getCell(2,23).ressurect();
        board.getCell(6,23).ressurect();
        board.getCell(1,25).ressurect();
        board.getCell(2,25).ressurect();
        board.getCell(6,25).ressurect();
        board.getCell(7,25).ressurect();

        board.getCell(3,35).ressurect();
        board.getCell(3,36).ressurect();
        board.getCell(4,35).ressurect();
        board.getCell(4,36).ressurect();*/


        while(true) {
            board.gameOfLife();
        }
    }


}
