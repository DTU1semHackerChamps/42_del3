import monopoly_junior.Language;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LanguageTest {


    @Test
    void languageInit() throws IOException {
        HashMap<String, String > teststringlist = Language.languageInit("English");
        assertEquals("has won!",teststringlist.get("playerWin"));
    }

}