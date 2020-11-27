package monopoly_junior;

import ChanceCard.JailCard;
import gui_main.GUI;

import java.util.Arrays;
import java.util.HashMap;

public class Player {
    private int balance;
    private int position;
    private String playerName;
    private boolean jailCard;
    private boolean inPrison;
    private int playerNum;
    private int lastPlayerPosition;



    public Player(int balance, int position, String playerName, boolean jailCard,int playerNum, int lastPlayerPosition, boolean inPrison){

        this.balance = balance;
        this.position = position;
        this.jailCard = jailCard;
        this.playerName = playerName;
        this.playerNum = playerNum;
        this.lastPlayerPosition = lastPlayerPosition;
        this.inPrison = inPrison;

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

    public void setPosition(int newPosition) {
        if(position > newPosition){
            balance += 2;
        }
        position = newPosition;
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
            position -= 24;
            balance += 2;
       }


       return position;
    }

    public void prison(){
        if(inPrison){
            if(jailCard){
                jailCard = false;
            } else {
                balance -= 1;
            }
            inPrison = false;
        }
    }

    public boolean goToPrison(){
        if(position == 18){
            position = 6;
            inPrison = true;
        }
        return inPrison;
    }

    public static boolean lost (Player[] players){
        boolean lostCheck = false;
        for(int i = 0; i < players.length; i++){
            if(players[i].getBalance() <= 0){
                lostCheck = true;
            }
        }
        return lostCheck;
    }

    public static boolean whoWon(Player[] players, Tile[] tiles,HashMap<String,String> stringList, GUI gui){
        int[][] balance = new int[players.length][2];
        boolean [] winners = new boolean[players.length];
        int highBalance = 0;
        int highBalance2 = 0;
        int winner = 0;

        int[] playerPropertyBalances = new int[players.length];

        for(int i = 0; i < tiles.length; i++){
            switch(tiles[i].getPropertyOwner()){
                case 1: playerPropertyBalances[0] += tiles[i].getBalanceChange();
                    break;
                case 2: playerPropertyBalances[1] += tiles[i].getBalanceChange();
                    break;
                case 3: playerPropertyBalances[2] += tiles[i].getBalanceChange();
                    break;
                case 4: playerPropertyBalances[3] += tiles[i].getBalanceChange();
                    break;
            }
        }

        for (int i = 0; i < players.length; i++) {
            if(players[i].getBalance() > highBalance) {
                highBalance = players[i].getBalance();
            }
        }

        for(int i = 0; i < players.length; i++){
            balance[i][0] = players[i].getBalance();
            balance[i][1] = i + 1;
            if(highBalance == balance[i][0]){
                winners[balance[i][1]-1] = true;
            }
        }


        for (int i = 0; i < players.length; i++) {
            if(winners[i]){
                if(playerPropertyBalances[i] > highBalance2){
                    winner = i + 1;
                    highBalance2 = playerPropertyBalances[i];
                }
            }
        }

        return gui.getUserLeftButtonPressed("Player " + winner + " " + stringList.get("winScreenMessage"),stringList.get("winTrueButton"),stringList.get("winFalseButton"));
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
                case 2: players[i-1] = new Player(20,0,playerName,false, i, 0, false);
                    break;
                case 3: players[i-1] = new Player(18,0,playerName,false, i, 0, false);
                    break;
                case 4: players[i-1] = new Player(16,0,playerName,false, i, 0, false);
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
