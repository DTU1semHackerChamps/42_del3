package ChanceCard;

import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public class ChooseColorCard extends ChanceCard{

    private int color1;
    private int color2;
    private String colorName1;
    private String colorName2;
    public ChooseColorCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui, int color1, int color2,String colorName1, String colorName2) {
        super(cardDescription, tiles, players, currentPlayer, gui);
        this.color1 = color1;
        this.color2 = color2;
        this.colorName1 = colorName1;
        this.colorName2 = colorName2;

    }

    @Override
    public void useChanceCard() {
        gui.showMessage(cardDescription);
        boolean ownerArray[] = new boolean[4];
        boolean if1 = false;
        boolean if2 = false;
        boolean colorSelection = false;

        if(tiles[Tile.goToColor(color1)].getPropertyOwner() != 0){
            ownerArray[0] = true;
        }
        if(tiles[Tile.goToColor(color1)+1].getPropertyOwner() != 0){
            ownerArray[1] = true;
        }
        if(tiles[Tile.goToColor(color2)].getPropertyOwner() != 0){
            ownerArray[2] = true;
        }
        if(tiles[Tile.goToColor(color2)+1].getPropertyOwner() != 0){
            ownerArray[3] = true;
        }

        //Buy property screen if both of color2 properties are owned, the player will only get the choice of color1 properties
        if((!ownerArray[0] || !ownerArray[1]) && ownerArray[2] && ownerArray[3]){
            gui.getUserButtonPressed("",colorName1);
            if1=true;
            colorSelection = true;
        }

        //Buy property screen if both of color1 properties are owned, the player will only get the choice of color2 properties
        if(ownerArray[0] && ownerArray[1] && (!ownerArray[2] || !ownerArray[3])){
            gui.getUserButtonPressed("",colorName2);
            if2=true;
        }

        //If at least one property of each color is not owned or all properties are owned, you will get the selection between both colors.
        if(!if1 && !if2){
            if(gui.getUserLeftButtonPressed("",colorName1,colorName2)){
                colorSelection = true;
            }
        }

        if(colorSelection && (ownerArray[0] ^ ownerArray[1])){

            if(ownerArray[1]) {
                gui.getUserButtonPressed("", tiles[Tile.goToColor(color1)].getTileName());
                tiles[Tile.goToColor(color1)].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color1));
            }else{
                gui.getUserButtonPressed("", tiles[Tile.goToColor(color1)+1].getTileName());
                tiles[Tile.goToColor(color1)+1].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color1)+1);        }

        }

        if(!colorSelection && (ownerArray[2] ^ ownerArray[3])){

            if(ownerArray[2]) {
                gui.getUserButtonPressed("", tiles[Tile.goToColor(color2)].getTileName());
                tiles[Tile.goToColor(color2)].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color2));
            }else{
                gui.getUserButtonPressed("", tiles[Tile.goToColor(color2)+1].getTileName());
                tiles[Tile.goToColor(color2)+1].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color2)+1);
            }

        }

        if(colorSelection && ((!ownerArray[0] && !ownerArray[1]) || (ownerArray[0] && ownerArray[1]))){

            int playerNum = 0;
            int balanceChange;

            if(gui.getUserLeftButtonPressed("", tiles[Tile.goToColor(color1)].getTileName(), tiles[Tile.goToColor(color1)+1].getTileName())) {
                playerNum = tiles[Tile.goToColor(color1)].getPropertyOwner();
                balanceChange = tiles[Tile.goToColor(color1)].getBalanceChange();
                tiles[Tile.goToColor(color1)].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color1));
            }
            else{
                playerNum = tiles[Tile.goToColor(color1)+1].getPropertyOwner();
                balanceChange = tiles[Tile.goToColor(color1)+1].getBalanceChange();
                tiles[Tile.goToColor(color1)+1].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color1)+1);
            }

            if(playerNum != 0){
                currentPlayer.addBalance(-balanceChange);
                players[playerNum].addBalance(balanceChange);
            }

        }

        if(!colorSelection && ((!ownerArray[2] && !ownerArray[3]) || (ownerArray[2] && ownerArray[3]))){

            int playerNum = 0;
            int balanceChange;

            if(gui.getUserLeftButtonPressed("", tiles[Tile.goToColor(color2)].getTileName(), tiles[Tile.goToColor(color2)+1].getTileName())) {
                playerNum = tiles[Tile.goToColor(color2)].getPropertyOwner();
                balanceChange = tiles[Tile.goToColor(color2)].getBalanceChange();
                tiles[Tile.goToColor(color2)].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color2));
            }
            else{
                playerNum = tiles[Tile.goToColor(color2)+1].getPropertyOwner();
                balanceChange = tiles[Tile.goToColor(color2)+1].getBalanceChange();
                tiles[Tile.goToColor(color2)+1].setPropertyOwner(currentPlayer.getPlayerNum());
                currentPlayer.setPosition(Tile.goToColor(color2)+1);
            }

            if(playerNum != 0){
                currentPlayer.addBalance(-balanceChange);
                players[playerNum].addBalance(balanceChange);
            }

        }

    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;

    }
}
