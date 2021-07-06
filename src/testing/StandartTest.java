package testing;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;

public class StandartTest {
    static private Board board;
    @BeforeAll
    static void initAll() {
        board = new Board(16);
        int x = 5;
        int y = 5;
        board.getCell(x, y).ressurect();

        board.getCell(x-1, y).ressurect();//left
        board.getCell(x+1, y).ressurect();//right
        board.getCell(x, y+1).ressurect();//bottom
        board.getCell(x, y-1).ressurect();//top
        board.getCell(x+1, y+1).ressurect();//bottom right
        board.getCell(x+1, y-1).ressurect();//top right
        board.getCell(x-1, y-1).ressurect();//top left
        board.getCell(x-1, y+1).ressurect();////bottom left


    }


    @Test
    void shouldGetCell() {
        board.getCell(3, 15).die();
        Assertions.assertNotNull(board.getCell(3, 15));
    }
    @Test
    void shouldGetAll() {
        Assertions.assertEquals(8, board.getNeighbours(board.getCell(5,5)));

    }
    @Test
    void shouldGetThree() {
        board.getCell(3,1).ressurect();
        board.getCell(3,2).ressurect();
        board.getCell(3,3).ressurect();
        Assertions.assertEquals(3, board.getNeighbours(board.getCell(2,2)));
    }
    @Test
    void shouldGetOne() {
        board.getCell(1,0).die();
        board.getCell(0,1).ressurect();
        Assertions.assertEquals(1, board.getNeighbours(board.getCell(0,0)));
    }



}
