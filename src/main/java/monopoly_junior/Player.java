package monopoly_junior;

import ChanceCard.JailCard;

public class Player {
    private int balance;
    private int position;
    private String playerName;
    private boolean jailCard;
    private int playerNum;



    public Player(int balance, int position, String playerName, boolean jailCard,int playerNum){

        this.balance = balance;
        this.position = position;
        this.jailCard = jailCard;
        this.playerName = playerName;
        this.playerNum = playerNum;

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

       if(position > 12){
            position -= 12;
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



    //

    private Player[] players;

    public PlayerList(int amount){

    }
}
