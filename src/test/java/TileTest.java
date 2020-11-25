import monopoly_junior.Tile;

import static org.junit.jupiter.api.Assertions.*;



public class TileTest {
    // tests if the program correctly adds or subtracts the correct amount of points and if the extraturn rule works
    @org.junit.jupiter.api.Test
    void tileListInit() {
        Tile[] tilesTest = new Tile[12];
        tilesTest = Tile.tileListInit();
        assertEquals(2,tilesTest[1].getBalanceChange());
        assertEquals(-100,tilesTest[2].getBalanceChange());


    }
}


