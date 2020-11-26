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
     * @param dice2 face value of dice 2
     */

    public static void displayDice(GUI gui,int dice1, int dice2){
        //gui.setDice(dice1,dice2);
        gui.setDice(dice1,4,1,dice2,5,1);


    }

    /**
     * This method initializes and has a randomized color setting for the tiles and and bg.
     * It also uses an if statement to translate the index of one array of 12 to an array of 16 with
     * spaces at index 0 4 8 12
     * @param fields is the current GUI_Field []
     * @return Returns gui with monopoly_junior.Tile names, monopoly_junior.Tile balance and random colors
     * for the tiles and the
     * background
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
                street.setSubText("M" + tileBalance);

                fields[i] = street;
                fields[i].setBackGroundColor(Color.getHSBColor(H,S,B));
            }

        GUI gui = new GUI(fields,Color.getHSBColor((float)0.355,(float)0.19,(float)0.87));


        return gui;

    }

    /**
     * This method is used to add a GUI_Player to the GUI and it also initializes and returns that GUI_Player
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
     * The pop up when a player wins.
     * @param gui Current GUI
     * @param winScreenMessage The message displayed in the top left
     * @param winTrueButton True button text
     * @param winFalseButton false button text in this case it closes the program.
     * @return Returns a boolean true or false. In the case used to continue the do while loop
     */

    public static boolean winScreen(GUI gui, String winScreenMessage, String winTrueButton, String winFalseButton){
        boolean buttonPress = false;

       buttonPress = gui.getUserLeftButtonPressed(winScreenMessage, winTrueButton, winFalseButton);
       if(!buttonPress){
           System.exit(0);
       }

        return buttonPress;
    }

    /**
     * Displays both players current position on the board.
     * @param fields The fields [] array for the fields on the board
     * @param positionPlayer1 Position of player 1
     * @param positionPlayer2 Position of player 2
     * @param gui_Player1 The GUI_Player one used to change the car position
     * @param gui_Player2 The GUI_Player two used to change the car position
     */
    public static void displayPosition(GUI_Field[] fields, int positionPlayer1, int positionPlayer2, GUI_Player gui_Player1, GUI_Player gui_Player2, int diceSum) throws InterruptedException {


//        for (int i = 0; i < 24; i++) {
//
//            fields[i].removeAllCars();
//            fields[i].setCar(gui_Player1, false);
//            fields[i].setCar(gui_Player2, false);
//
//        }

        fields[positionPlayer2].setCar(gui_Player2, true);
        int lastPlayerPos = Math.abs(positionPlayer1 - diceSum);

        fields[lastPlayerPos].setCar(gui_Player1, false);
        for (int j = lastPlayerPos; j <= positionPlayer1; j++) {

                fields[j].setCar(gui_Player1, true);
                Thread.sleep(250);
                fields[j].setCar(gui_Player1, false);

        }
        fields[positionPlayer1].setCar(gui_Player1, true);
    }

    /**
     * Returns a string with the name of the player who's turn it is
     * @param playerturn Checks who's turn it is if, true player 1 if false player 2.
     * @param playerText The text displayed after the players name.
     * @param player1name Name of player 1.
     * @param player2name Name of monopoly_junior.Player 2.
     * @return turn String including the name of the player
     */

    public static String displayPlayerTurn(Boolean playerturn, HashMap<String,String> playerText, String player1name, String player2name){
        String thisText;
        if(playerturn){
            thisText = player1name + " " + playerText.get("playerTurn");
        } else {
            thisText = player2name + " " + playerText.get("playerTurn");
        }
        return thisText;
    }

    /**
     * Returns a string with the name of the player who has won it is.
     * @param playerturn Checks who's turn it is, if true player 1 if false player 2.
     * @param playerText The text displayed after the players name.
     * @param player1name Name of player 1.
     * @param player2name Name of player 2.
     * @return win String including the name of the player.
     */
    public static String displayPlayerWin(Boolean playerturn, HashMap<String,String> playerText, String player1name, String player2name){
        String thisText;
        if(playerturn){
            thisText = player1name + " " + playerText.get("playerWin");
        } else {
            thisText = player2name + " " + playerText.get("playerWin");
        }
        return thisText;
    }

    /**
     * Used to display the tile text of the current position after a roll.
     * @param tileTexts String[] with the texts of the tiles
     * @param position The current position of the player
     * @param gui the gui currently used
     */

    public static void displayTileText(String[] tileTexts, int position, GUI gui){
        gui.showMessage(tileTexts[position]);
    }


}
