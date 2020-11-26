package ChanceCard;

import gui_main.GUI;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public abstract class ChanceCard {

    protected String cardDescription;
    protected Tile[] tiles;
    protected Player[] players;
    protected Player currentPlayer;
    protected GUI gui;

    public ChanceCard(String cardDescription, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui) {
        this.tiles = tiles;
        this.cardDescription = cardDescription;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gui = gui;
    }

     public abstract void useChanceCard();

}
