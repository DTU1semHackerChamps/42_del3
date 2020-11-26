package monopoly_junior;

import ChanceCard.JailCard;
import gui_main.GUI;

import java.util.HashMap;

public class Player {
    private int balance;
    private int position;
    private String playerName;
    private boolean jailCard;
    private int playerNum;
    private int lastPlayerPosition;



    public Player(int balance, int position, String playerName, boolean jailCard,int playerNum, int lastPlayerPosition){

        this.balance = balance;
        this.position = position;
        this.jailCard = jailCard;
        this.playerName = playerName;
        this.playerNum = playerNum;
        this.lastPlayerPosition = lastPlayerPosition;

    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public int getLastPlayerPosition(){return lastPlayerPosition;}
    public void setLastPlayerPosition(int lastPlayerPosition){this.lastPlayerPosition = lastPlayerPosition;}

    public void saveLastPlayerPosition(){
        lastPlayerPosition = position;
    }


    public void setJailCard(boolean jailCard) {
        this.jailCard = jailCard;
    }

    public boolean isJailCard() {
        return jailCard;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * adds tile balance to player balance
     * @return player balance
     */
    public int getBalance() {
        return balance;
    }

    public void payRent(Player [] players, Player currentPlayer, int balanceChange, int owner){
        if((currentPlayer.getPlayerNum() != owner) && (owner != 0)) {
            currentPlayer.addBalance(-balanceChange);
            players[owner].addBalance(balanceChange);
        }
    }

    public int addBalance(int tileBalanceChange){
        balance += tileBalanceChange;
        if (balance < 0){
            balance = 0;
        }
        return balance;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    /**
     * add faceValue to the player's current position
     * @param faceValue
     * @return player position
     */
    public int addPosition(int faceValue){
       position += faceValue;

       if(position > 23){
            position -= 23;
       }
       return position;
    }



    /**
     * Checks if winning requirement is reached
     * @return returns if a player has won
     */


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }



    // From here new code added by Zahed.


//    private boolean isDeath;
//    private boolean isWinner;

//    public  void PlayerSartPos(){
//        balance = 0;
//        isDeath = false;
//        isWinner = false;
//
//
//    }

     String[] player;

    public static Player[] PlayerList(HashMap<String, String> stringList, GUI gui){
        String playerName = "";
        int numOfPlayer = 0;

        numOfPlayer = Integer.parseInt(gui.getUserButtonPressed(stringList.get("ChooseCharacter1"), "2", "3", "4"),10);

        Player[] players = new Player[numOfPlayer];

        String[] names = {stringList.get("CarCharacter"), stringList.get("CatCharacter"), stringList.get("DogCharacter"), stringList.get("BoatCharacter")};


        for (int i = 1; i <= numOfPlayer; i++) {
            do{
                playerName = gui.getUserButtonPressed(stringList.get("ChooseCharacter2") + " " + i + ".", names[0], names[1], names[2], names[3]);
                if(playerName.equals(names[0])){
                    names[0] = " ";
                }
                if(playerName.equals(names[1])){
                    names[1] = " ";
                }
                if(playerName.equals(names[2])){
                    names[2] = " ";
                }
                if(playerName.equals(names[3])){
                    names[3] = " ";
                }

            }while (playerName.equals(" "));

            switch (numOfPlayer){
                case 2: players[i-1] = new Player(20,0,playerName,false, i, 0);
                    break;
                case 3: players[i-1] = new Player(18,0,playerName,false, i, 0);
                    break;
                case 4: players[i-1] = new Player(16,0,playerName,false, i, 0);
                    break;
            }



        }
    return players;
    }

    public static int nextPlayer(int index, Player[] players){
        index = ++index % players.length;
        return index;
    }



}
