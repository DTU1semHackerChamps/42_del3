import java.io.IOException;
import java.util.HashMap;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import monopoly_junior.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Tile[] tiles = Tile.tileListInit();

        System.out.println(tiles[1].getBalanceChangeExtra(tiles));
        tiles[1].setPropertyOwner(1);
        System.out.println(tiles[1].getBalanceChangeExtra(tiles));
        tiles[2].setPropertyOwner(1);
        System.out.println(tiles[1].getBalanceChangeExtra(tiles));
    }

}