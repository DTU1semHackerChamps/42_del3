package ChanceCard;
import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public class JailCard extends ChanceCard {

    public JailCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui) {
        super(cardDescription, tiles, players, currentPlayer, gui);
    }

    @Override
    public void useChanceCard() {
        gui.showMessage(cardDescription);
        currentPlayer.setJailCard(true);
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


}
