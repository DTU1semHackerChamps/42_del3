import monopoly_junior.Language;
import monopoly_junior.Tile;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;



public class TileTest {
    // tests if the program correctly adds or subtracts the correct amount of points and if the extraturn rule works
    @org.junit.jupiter.api.Test
    void tileListInit() throws IOException {
        HashMap<String, String> stringList = Language.languageInit("english");
        Tile[] tilesTest = Tile.tileListInit(stringList);
        assertEquals(1,tilesTest[1].getBalanceChange());
        assertNotEquals(-100,tilesTest[2].getBalanceChange());



    }
}


