package ChanceCard;
import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public class moveMoneyCard extends ChanceCard {
    private int balanceChange;
    private int newPosition;
    private boolean positionSwitch;

    public moveMoneyCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui, int balanceChange, int newPosition, boolean positionSwitch) {
        super(cardDescription, tiles, players, currentPlayer, gui);
        this.balanceChange = balanceChange;
        this.newPosition = newPosition;
        this.positionSwitch = positionSwitch;
    }

    @Override
    public void useChanceCard() {
        gui.showMessage(cardDescription);
        currentPlayer.addBalance(balanceChange);

        if(positionSwitch){
            currentPlayer.setPosition(newPosition);
        }
    }
}
