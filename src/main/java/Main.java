import java.io.IOException;
import java.util.HashMap;

import ChanceCard.ChanceCard;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import monopoly_junior.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // loads the file of the corresponding language input string
        HashMap<String, String> stringList = Language.languageInit("english");

        String[] tileTexts = Language.tileTexts(stringList);

        // Gui field initialized for use in everything related to the GUI
        GUI_Field[] fields = new GUI_Field[24];
        GUI gui = Displaymanager.initBoard(stringList, fields);

        Player currentPlayer = new Player(0,0,"", false, 0);

        do{
            Displaymanager.initBoard(stringList, fields);

            // Currentplayer is used to decide which player is rolling the dice and affected by the balance change, position change and extra turn

            Player[] players = Player.PlayerList(stringList, gui);
            GUI_Player[] gui_Players = Displaymanager.displayAddPlayer(stringList, gui, fields, players);



            //tileList initialized with the tileListInit() method which is a set list
            Tile[] tileList = Tile.tileListInit(stringList);

            ChanceCard[] cards = ChanceCardManager.cardArrayInit(stringList, tileList, players, currentPlayer, gui);
            ChanceCardManager.cardShuffle(cards);

            Dice dice = new Dice(0);
            int index = 0;

            do{
                index = Player.nextPlayer(index, players);
                currentPlayer = players[index];
                dice.rollDice();
                currentPlayer.addPosition(dice.getFaceValue());
                tileList[currentPlayer.getPosition()].tileAvailable(currentPlayer.getPlayerNum());


            }while(true);

        }while(true);
    }

}