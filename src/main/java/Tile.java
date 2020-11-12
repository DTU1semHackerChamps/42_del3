public class Tile {
    /**
     * constructor
     */
    private int balanceChange;
    private boolean extraTurn;
    private String tileName;
    public Tile(int balanceChange, boolean extraTurn,String name)
    {
        this.balanceChange = balanceChange;
        this.extraTurn = extraTurn;
        tileName = name;

    }

    public void setBalanceChange(int balanceChange) {
        this.balanceChange = balanceChange;
    }

    public void setExtraTurn(boolean extraTurn) {
        this.extraTurn = extraTurn;
    }

    public int getBalanceChange() {
        return balanceChange;
    }

    public boolean isExtraTurn() {
        return extraTurn;
    }

    public String getTileName() {
        return tileName;
    }

    /**
     * array of tile list
     * @return returns array of the specified initiated tiles
     */
    public static Tile [] tileListInit(){
        Tile [] tiles = new Tile[13];
        Tile start = new Tile (0,false,"Start");
        Tile tower = new Tile (250,false, "Tower");
        Tile crater = new Tile (-100,false, "Crater");
        Tile palaceGates = new Tile (100,false, "Palace gates");
        Tile coldDesert = new Tile (-20,false, "Cold Desert");
        Tile walledCity = new Tile (180,false, "Walled city");
        Tile monastery = new Tile (0,false, "Monastery");
        Tile blackCave = new Tile (-70,false, "Black cave");
        Tile hutsInTheMountain = new Tile (60,false, "Huts in the woods");
        Tile theWerewall = new Tile (-80,true, "The Werewall");
        Tile thePit = new Tile (-50,false, "The pit");
        Tile goldmine = new Tile (650,false,"Goldmine");

        tiles[1] = start;
        tiles[2] = tower;
        tiles[3] = crater;
        tiles[4] = palaceGates;
        tiles[5] = coldDesert;
        tiles[6] = walledCity;
        tiles[7] = monastery;
        tiles[8] = blackCave;
        tiles[9] = hutsInTheMountain;
        tiles[10] = theWerewall;
        tiles[11] = thePit;
        tiles[12] = goldmine;

        return tiles;
    }
}
