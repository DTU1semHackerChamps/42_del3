
package ChanceCard;
import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public class ColorCard extends ChanceCard {

    private int color;
    private String colorName;

    public ColorCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui,int color, String colorName) {
        super(cardDescription, tiles, players, currentPlayer, gui);
        this.color = color;
        this.colorName = colorName;
    }


    @Override
    public void useChanceCard() {
        gui.showMessage(cardDescription +" "+ colorName + ".");


        int playerNum = 0;
        int balanceChange;
        boolean owner1 = false;
        boolean owner2 = false;
        boolean selection = false;

        //The til for the Skatepark
        if(color == 9){
            currentPlayer.setPosition(10);
        }

        if(tiles[Tile.goToColor(color)].getPropertyOwner() != 0){
            owner1 = true;

        }
        if(tiles[Tile.goToColor(color) +1].getPropertyOwner() != 0){
            owner2 = true;
        }




        if (owner1 ^ owner2){
            String property1 = tiles[Tile.goToColor(color)].getTileName();
            String property2 = tiles[Tile.goToColor(color) +1].getTileName();
            if (owner2) {
                selection = true;
                gui.getUserButtonPressed("",property1);
            }
            else
                {  gui.getUserButtonPressed("",property2);
            }


        } else {
            if (gui.getUserLeftButtonPressed("", tiles[Tile.goToColor(color)].getTileName(), tiles[Tile.goToColor(color) + 1].getTileName())){
                selection = true;

            }
        }

        if (selection){
            currentPlayer.setPosition(Tile.goToColor(color));
            playerNum = tiles[Tile.goToColor(color)].getPropertyOwner();
            balanceChange = tiles[Tile.goToColor(color)].getBalanceChange();
            tiles[Tile.goToColor(color)].setPropertyOwner(currentPlayer.getPlayerNum());

        } else {
            playerNum = tiles[Tile.goToColor(color) + 1].getPropertyOwner();
            balanceChange = tiles[Tile.goToColor(color) + 1].getBalanceChange();
            tiles[Tile.goToColor(color) +1].setPropertyOwner(currentPlayer.getPlayerNum());
            currentPlayer.setPosition(Tile.goToColor(color) +1);
        }

        if(playerNum != 0) {
            players[playerNum].addBalance(balanceChange);
            currentPlayer.addBalance(-balanceChange);

        }




    }
}

