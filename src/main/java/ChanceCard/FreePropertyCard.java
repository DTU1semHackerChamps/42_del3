package ChanceCard;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import monopoly_junior.Player;
import monopoly_junior.Tile;
import gui_main.GUI;


public class FreePropertyCard {
    // gratis felt nr: 4. 8. 9. 15. 17. 18. 19. 20.
    // 4 - orange felt
    // 8 - orange eller grøn felt
    // 9 - lyseblåt felt
    // 15 - pink eller mørkeblåt felt
    // 17 - rødt felt
    // 18 - skaterparken
    // 19 - lyseblåt eller rødt felt
    // 20 - brunt eller gult felt

    public void useFreePropertyCard(Player[] currentPlayers, Tile[] tiles, Player currentPlayer, GUI gui){
        if(gui.getUserLeftButtonPressed("ChooseColour", "Yellow", "Blue")){
            nextColour(currentPlayer,1);
        } else {
            nextColour(currentPlayer,2);
        }

        currentPlayer.

    }
}

