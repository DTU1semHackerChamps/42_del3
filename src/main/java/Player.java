public class Player {
    private int balance;
    private int position;
    private boolean playerTurn;
    private String playerName;



    public Player(int balance, int position, boolean playerTurn, String name){

        this.balance = balance;
        this.position = position;
        this.playerTurn = playerTurn;
        playerName = name;

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

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public boolean getPlayerTurn(){
        return playerTurn;
    }

    /**
     * Checks if winning requirement is reached
     * @return returns if a player has won
     */
    public boolean hasWon(){
        boolean winStatus = false;
        if(balance >= 3000){
            winStatus = true;
        }
        return winStatus;
    }

    /**
     * player switch methode
     * @param player1
     * @param player2
     * @return returns who is the current player
     */
    public static Player shiftPlayer (Player player1, Player player2){
        Player currentPlayer;
        if (player1.getPlayerTurn()){
            player1.setPlayerTurn(false);
            currentPlayer = player1;
        } else {
            player1.setPlayerTurn(true);
            currentPlayer = player2;
        }
        return currentPlayer;
    }

    /**
     * extra turn methode
     * @param player1
     * @param tileExtraTurn
     */
    public static void extraTurn (Player player1, boolean tileExtraTurn){
        if (tileExtraTurn) {
            if(player1.getPlayerTurn()){
                player1.setPlayerTurn(false);
            } else {
                player1.setPlayerTurn(true);
            }
        }
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
