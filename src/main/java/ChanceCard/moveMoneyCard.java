package ChanceCard;
import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public class moveMoneyCard extends ChanceCard {
    private int balanceChange;
    private int newPosition;
    private boolean positionSwitch;
    private boolean skatePark;

    public moveMoneyCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui, int balanceChange, int newPosition, boolean positionSwitch, boolean skatePark) {
        super(cardDescription, tiles, players, currentPlayer, gui);
        this.balanceChange = balanceChange;
        this.newPosition = newPosition;
        this.positionSwitch = positionSwitch;
        this.skatePark = skatePark;
    }

    @Override
    public void useChanceCard() {
        gui.showMessage(cardDescription);
        currentPlayer.addBalance(balanceChange);

        if(positionSwitch){
            currentPlayer.setPosition(newPosition);
            if(skatePark){
                currentPlayer.setPosition(10);
                if(tiles[10].getPropertyOwner() != 0){
                    tiles[10].setPropertyOwner(currentPlayer.getPlayerNum());

                }else{
                    currentPlayer.payRent(players, currentPlayer, balanceChange, tiles[10].getPropertyOwner());
                }


            }
        }
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
