import java.io.IOException;
import java.util.HashMap;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Main {
    public static void main(String[] args) throws IOException {

        //tileList initialized with the tileListInit() method which is a set list
        Tile[] tileList = Tile.tileListInit();

        // loads the file of the corresponding language input string
        HashMap<String,String> stringList = Language.languageInit("english");

        String[] tileTexts = Language.tileTexts(stringList);

        Dice dice1 = new Dice(0);
        Dice dice2 = new Dice(0);
        int sumOfDice;

        // Gui field initialized for use in everything related to the GUI
        GUI_Field[] fields = new GUI_Field[16];
        GUI gui = Displaymanager.initBoard(fields);
        Player player1 = new Player(1000, 1, true, gui.getUserString(stringList.get("typeName1")));
        Player player2 = new Player(1000, 1, false, gui.getUserString(stringList.get("typeName2")));

        // Currentplayer is used to decide which player is rolling the dice and affected by the balance change, position change and extra turn
        Player currentPlayer = new Player(0,0,false,"");
        GUI_Player gui_Player1 = Displaymanager.displayAddPlayer(gui, fields, player1.getPlayerName(), player1.getBalance(), true);
        GUI_Player gui_Player2 = Displaymanager.displayAddPlayer(gui, fields, player2.getPlayerName(), player2.getBalance(), false);

        do{

            //Default game values restored
            player1.setPosition(1);
            player2.setPosition(1);
            player1.setBalance(1000);
            player2.setBalance(1000);
            player1.setPlayerTurn(true);
            player2.setPlayerTurn(false);
            gui_Player1.setBalance(player1.getBalance());
            gui_Player2.setBalance(player2.getBalance());
            Displaymanager.displayPosition(fields, player1.getPosition(), player2.getPosition(), gui_Player1, gui_Player2);

            // While loop for the turns of the game
            while(Displaymanager.rollScreen(gui, Displaymanager.displayPlayerTurn(player1.getPlayerTurn(),stringList,player1.getPlayerName(),player2.getPlayerName()), stringList.get("rollButton"))){
                // Current player set
                currentPlayer = Player.shiftPlayer(player1, player2);
                // Sum of the dice is calculated
                sumOfDice = dice1.rollDice() + dice2.rollDice();
                // updating the position of current player corresponding to the sum of the dice
                currentPlayer.addPosition(sumOfDice);
                // updating the balance of current player corresponding to the set balance amount of a tile
                currentPlayer.addBalance(tileList[currentPlayer.getPosition()].getBalanceChange());
                // Determining if the current player gets an extra turn
                Player.extraTurn(player1, tileList[currentPlayer.getPosition()].isExtraTurn());

                // Updating the balance of the players in the gui
                gui_Player1.setBalance(player1.getBalance());
                gui_Player2.setBalance(player2.getBalance());

                // Updating the position, the dice of the players in the gui
                Displaymanager.displayPosition(fields, player1.getPosition(), player2.getPosition(), gui_Player1, gui_Player2);
                Displaymanager.displayDice(gui, dice1.getFaceValue(), dice2.getFaceValue());
                // Displays the tiles Text when player moves there as a pop-up.
                Displaymanager.displayTileText(tileTexts,currentPlayer.getPosition(), gui);
                // Checks for a player with more than 3000 balance
                if(currentPlayer.hasWon()){
                    break;
                }
            }
        // Win screen gives the option to either restart or exit the game.
        }while (Displaymanager.winScreen(gui,Displaymanager.displayPlayerWin(player1.getPlayerTurn(),stringList,player1.getPlayerName(), player2.getPlayerName()),stringList.get("winTrueButton"), stringList.get("winFalseButton")));
    }
}