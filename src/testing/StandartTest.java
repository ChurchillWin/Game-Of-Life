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
        int x = 2;
        int y = 2;
        board.getCell(x, y).ressurect();
        board.getCell(x+1, y).ressurect();
        board.getCell(x-1, y).ressurect();
        board.getCell(x, y+1).ressurect();
        board.getCell(x, y-1).ressurect();
    }


    @Test
    void succeedingTest() {
        Assertions.assertNotNull(board.getCell(3, 15));
    }
    @Test
    void Get_Alive_Neighbours() {
        Assertions.assertEquals(4, board.getNeighbours(board.getCell(2,2)));

    }



}
