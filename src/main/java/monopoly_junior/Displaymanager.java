package monopoly_junior;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.GUI_Street;
import gui_fields.GUI_Field;
import gui_fields.GUI_Board;

import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Displaymanager {



    public static boolean rollScreen(GUI gui, String rollScreenMessage, String rollButton){
        boolean buttonPress;
        buttonPress = gui.getUserButtonPressed( rollScreenMessage, rollButton).equals(rollButton);
        return buttonPress;
    }

    /**
     * Displays the current dice values in GUI
     * @param gui the current GUI
     * @param dice1 face value of dice 1
     */

    public static void displayDice(GUI gui,int dice1){
        //gui.setDice(dice1,dice2);
        gui.setDice(dice1,5,1,dice1,5,1);


    }

    /**
     * This method initializes the board and has switch case that determines the color of the tile.
     * It also has an if statement that checks for tiles with 0 rent and removes the subtext,
     * and a special one for the prison/visit prison.
     * @param stringList is the names of the tiles taken form a list of strings in the Language class.
     * @param fields is the current GUI_Field[]
     * @return Returns gui with monopoly_junior.Tile names, monopoly_junior.Tile balance
     * and specific colors for the tiles and background
     */
    public static GUI initBoard(HashMap<String, String> stringList, GUI_Field[] fields){

        GUI.setNull_fields_allowed(true);
        Tile[] tiles = Tile.tileListInit(stringList);
        String tileBalance, tileName;
        float H = 0, S = 0,B = 0;

        /* HSB colors
        BoardBackground H:0.35f S:0.19f B:0.87f
        0 : White H = 0.5f; S = 0f; B = 0.98f;
        1 : Brown H = 0.05f; S = 0.64f; B = 0.58f;
        2 : LightBlue H = 0.56f; S = 0.27f; B = 0.96f;
        3 : Magenta H = 0.91f; S = 0.67f; B = 0.83f;
        4 : Orange H = 0.09f; S = 0.87f; B = 0.97f;
        5 : Red H = 1.00f; S = 0.85f; B = 0.94f;
        6 : Yellow H = 0.15f; S = 0.83f; B = 0.98f;
        7 : Green H = 0.37f; S = 0.76f; B = 0.66f;
        8 : Blue H = 0.57f; S = 0.92f; B = 0.72f;

         */

        for (int i = 0; i < tiles.length; i++) {


                tileBalance = Integer.toString(tiles[i].getBalanceChange());
                tileName = tiles[i].getTileName();

                switch (tiles[i].getColor()){
                    case 0 :H = 0.5f; S = 0f; B = 0.98f;
                        break;
                    case 1 :H = 0.05f; S = 0.64f; B = 0.58f;
                        break;
                    case 2 :H = 0.56f; S = 0.27f; B = 0.96f;
                        break;
                    case 3 :H = 0.91f; S = 0.67f; B = 0.83f;
                        break;
                    case 4 :H = 0.09f; S = 0.87f; B = 0.97f;
                        break;
                    case 5 :H = 1.00f; S = 0.85f; B = 0.94f;
                        break;
                    case 6 :H = 0.15f; S = 0.83f; B = 0.98f;
                        break;
                    case 7 :H = 0.37f; S = 0.76f; B = 0.66f;
                        break;
                    case 8 :H = 0.57f; S = 0.92f; B = 0.72f;
                        break;

                }

                GUI_Street street = new GUI_Street();
                street.setTitle(tileName);
                if(tileBalance.equals(Integer.toString(tiles[3].getBalanceChange()))){
                    street.setSubText("");
                    if(tileName == tiles[6].getTileName()){
                        street.setTitle(tileName);
                        street.setSubText(stringList.get("VisitJailField"));
                    }
                }else {
                    street.setSubText("M" + tileBalance);
                }
                 street.setDescription(" ");

                fields[i] = street;
                fields[i].setBackGroundColor(Color.getHSBColor(H,S,B));
            }

        GUI gui = new GUI(fields,Color.getHSBColor((float)0.355,(float)0.19,(float)0.87));


        return gui;

    }

    /**
     * This method is used to add a GUI_Player to the GUI and it also initializes and returns that GUI_Player
     * @param stringList is the names of the characters taken form a list of strings
     * @param gui The current GUI
     * @param fields The current GUI_Field[]
     * @param player The name displayed in the GUI by the score
     * @return
     */
    public static GUI_Player[] displayAddPlayer(HashMap<String, String> stringList, GUI gui, GUI_Field[] fields, Player[] player){


        GUI_Player[] guiPlayerList = new GUI_Player[4];

        for (int i = 0; i < player.length; i++) {
            GUI_Car carColor = new GUI_Car();

            if(stringList.get("CatCharacter").equals(player[i].getPlayerName())) {
                carColor.setPrimaryColor(Color.orange);
            }
            else if(stringList.get("DogCharacter").equals(player[i].getPlayerName())){
                carColor.setPrimaryColor(Color.black);
            }
            else if(stringList.get("CarCharacter").equals(player[i].getPlayerName())){
                carColor.setPrimaryColor(Color.green);
            }
            else if(stringList.get("BoatCharacter").equals(player[i].getPlayerName())){
                carColor.setPrimaryColor(Color.blue);
            }

            GUI_Player gui_Player = new GUI_Player(player[i].getPlayerName(),player[i].getBalance(), carColor);
            gui.addPlayer(gui_Player);
            fields[0].setCar(gui_Player, true);
            guiPlayerList[i] = gui_Player;
        }

        return guiPlayerList;
    }


    /**
     * Displays all players position on the board
     * @param fields The fields [] array for the fields on the board
     * @param currentPlayer is the player turn
     * @param guiPlayer is the GUI_Player[]
     * @param lastPlayerPosition position of the player before the dice roll
     * @throws InterruptedException Can interrupt even if the sleep timer is not done
     */
    public static void displayPosition(GUI_Field[] fields, Player currentPlayer, GUI_Player[] guiPlayer, int lastPlayerPosition) throws InterruptedException {


        fields[lastPlayerPosition].setCar(guiPlayer[currentPlayer.getPlayerNum() - 1], false);
        for (int j = lastPlayerPosition; j <= currentPlayer.getPlayerNum(); j++) {

                fields[j].setCar(guiPlayer[currentPlayer.getPlayerNum() - 1], true);
                Thread.sleep(250);
                fields[j].setCar(guiPlayer[currentPlayer.getPlayerNum() - 1], false);

        }
        fields[currentPlayer.getPosition()].setCar(guiPlayer[currentPlayer.getPlayerNum() - 1], true);
    }

    /**
     * Returns a string with the name of the player who's turn it is
     * @param playerturn Checks who's turn it is if, true player 1 if false player 2.
     * @param playerText The text displayed after the players name.
     * @param player1name Name of player 1.
     * @param player2name Name of monopoly_junior.Player 2.
     * @return turn String including the name of the player
     */

    public static String displayPlayerTurn(HashMap<String,String> playerText, Player[] players, Player currentPlayer){
        String thisText = "";

        switch (currentPlayer.getPlayerNum()){
            case 1: thisText = players[0].getPlayerName() + " " + playerText.get("playerTurn");
            break;
            case 2: thisText = players[1].getPlayerName() + " " + playerText.get("playerTurn");
            break;
            case 3: thisText = players[2].getPlayerName() + " " + playerText.get("playerTurn");
            break;
            case 4: thisText = players[3].getPlayerName() + " " + playerText.get("playerTurn");
        }
        return thisText;
    }

    public static void  updatePlayerBalance(GUI gui, GUI_Player[] guiPlayer, Player[] players){
        for (int i = 0; i < players.length; i++) {
            guiPlayer[i].setBalance(players[i].getBalance());
        }

    }

     public static void updatePropertyOwners(GUI gui, GUI_Field[] fields, Tile[] tiles, Player[] players){
         for (int i = 0; i < fields.length; i++) {
             if(tiles[i].getPropertyOwner() != 0) {
                 fields[i].setDescription("Owner: " + players[tiles[i].getPropertyOwner() - 1].getPlayerName());
                 if(tiles[i].getBalanceChange() == 0){
                     fields[i].setDescription("");
                 }
             }
         }

     }

     public static void goToPrisonMessage(boolean goToPrison, HashMap<String,String> stringList, GUI gui, Player currentPlayer){
        if(goToPrison){
            gui.showMessage(currentPlayer.getPlayerName() + " " + stringList.get("GoToJailField"));
        }
     }

    /**
     * Used to display the tile text of the current position after a roll.
     * @param tileTexts String[] with the texts of the tiles
     * @param position The current position of the player
     * @param gui the gui currently used
     */

    public static void displayTileText(HashMap<String, String> stringList, GUI gui, Tile[] tiles, Player currentPlayer){
        if(currentPlayer.getPosition() != currentPlayer.getLastPlayerPosition())
            gui.showMessage(stringList.get("basisText1") + " " + tiles[currentPlayer.getPosition()].getTileName());
    }


}
