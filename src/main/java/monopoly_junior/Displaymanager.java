package monopoly_junior;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.GUI_Street;
import gui_fields.GUI_Field;

import java.awt.*;
import java.util.HashMap;

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
        gui.setDice(dice1,dice2);

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
    public static GUI initBoard(GUI_Field[] fields){

        GUI.setNull_fields_allowed(true);
        Tile[] tiles =  new Tile[24]; //Tile.tileListInit();
        String tileBalance, tileName;

        for (int i = 0; i < tiles.length; i++) {


                tileBalance = "PÅ BESØG"; //Integer.toString(tiles[i].getBalanceChange());
                tileName = " I FÆNGSEL"; //tiles[i].getTileName();


                GUI_Street street = new GUI_Street();
                street.setTitle(tileName);
                street.setSubText(tileBalance);

                fields[i] = street;
                fields[i].setBackGroundColor(Color.getHSBColor((float)Math.random(),(float)0.50,(float)0.85));
            }

        GUI gui = new GUI(fields,Color.getHSBColor((float)Math.random(),(float)0.60,(float)0.75));


        return gui;

    }

    /**
     * This method is used to add a GUI_Player to the GUI and it also initializes and returns that GUI_Player
     * @param gui The current GUI
     * @param fields The current GUI_Field[]
     * @param name The name displayed in the GUI by the score
     * @param balance The score number displayed
     * @param color True for blue player and false for red
     * @return
     */
    public static GUI_Player displayAddPlayer(GUI gui, GUI_Field[] fields, String name, int balance, boolean color){
        GUI_Car car1 = new GUI_Car();
        if(color) {
            car1.setPrimaryColor(Color.blue);
        }
        else{
            car1.setPrimaryColor(Color.red);
        }
        GUI_Player gui_Player = new GUI_Player(name,balance, car1);
        gui.addPlayer(gui_Player);
        fields[1].setCar(gui_Player, true);

        return gui_Player;
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
    public static void displayPosition(GUI_Field[] fields, int positionPlayer1, int positionPlayer2, GUI_Player gui_Player1, GUI_Player gui_Player2){


        for (int i = 1; i < 16; i++) {
            if ((i == 4)||(i == 8)||(i == 12)) {

            } else {
                fields[i].removeAllCars();
            }
        }
        switch (positionPlayer1) {
            case 4:
            case 5:
            case 6: positionPlayer1 += 1;
                break;
            case 7:
            case 8:
            case 9: positionPlayer1 += 2;
                break;
            case 10:
            case 11:
            case 12: positionPlayer1 += 3;
                break;
        }

        switch (positionPlayer2) {
            case 4:
            case 5:
            case 6: positionPlayer2 += 1;
                break;
            case 7:
            case 8:
            case 9: positionPlayer2 += 2;
                break;
            case 10:
            case 11:
            case 12: positionPlayer2 += 3;
                break;

        }

        fields[positionPlayer1].setCar(gui_Player1, true);
        fields[positionPlayer2].setCar(gui_Player2, true);

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
