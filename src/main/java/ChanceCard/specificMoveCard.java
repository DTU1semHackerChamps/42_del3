package ChanceCard;
import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;


public class specificMoveCard extends ChanceCard {



    public specificMoveCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui) {
        super(cardDescription, tiles, players, currentPlayer, gui);
    }


    @Override
    public void useChanceCard() {
        int addPosition;
        gui.showMessage(cardDescription);
        addPosition = Integer.parseInt(gui.getUserButtonPressed("","1","2","3","4","5"),10);
        currentPlayer.addPosition(addPosition);

    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
