package monopoly_junior;

import java.util.HashMap;

public class Tile {


    /**
     * constructor
     */
    private int balanceChange;
    private String tileName;
    public int propertyOwner;
    private int color;

    public Tile(String name,int balanceChange,int color,int propertyOwner)
    {
        this.balanceChange = balanceChange;
        this.tileName = name;
        this.color = color;
        this.propertyOwner = propertyOwner;
    }

    /**
     * array of tile list
     * @return returns array of the specified initiated tiles
     */

    public static Tile [] tileListInit(HashMap<String, String> stringList){
        Tile [] tiles = new Tile[24];
        Tile start = new Tile (stringList.get("StartField"),2,0,0);
        Tile theBurgerbar = new Tile (stringList.get("BurgerbarField"), 1,1,0);
        Tile pizzeria = new Tile (stringList.get("PizzeriaField"), 1, 1,0);
        Tile chanceCard = new Tile (stringList.get("ChanceCardField"), 0,0,0);
        Tile candyStore = new Tile (stringList.get("CandyStoreField"), 1,2,0);
        Tile iceCreamKiosk = new Tile (stringList.get("IceCreamField"), 1, 2,0);
        Tile visitPrison = new Tile (stringList.get("JailField"), 0,0,0);
        Tile museum = new Tile (stringList.get("MuseumField"), 2,3,0);
        Tile library = new Tile (stringList.get("LibraryField"), 2,3,0);
        Tile skatepark = new Tile (stringList.get("SkateparkField"), 2,4,0);
        Tile swimmingpool = new Tile (stringList.get("PoolField"),2,4,0);
        Tile freeParking = new Tile (stringList.get("FreeparkingField"),0,0,0);
        Tile arcade = new Tile (stringList.get("ArcadeField"), 3, 5,0);
        Tile cinema = new Tile (stringList.get("CinemaField"), 3, 5,0);
        Tile toyStore = new Tile (stringList.get("ToyStoreField"), 3,6,0);
        Tile petShop = new Tile (stringList.get("PetShopField"), 3, 6,0);
        Tile goPrison = new Tile (stringList.get("GoToJailField"), 0, 0,0);
        Tile bowlingAlley = new Tile (stringList.get("BowlingAlleyField"), 4,7,0);
        Tile zoo = new Tile (stringList.get("ZooField"), 4, 7,0);
        Tile waterPark = new Tile (stringList.get("WaterParkField"), 5, 8,0);
        Tile boardwalk = new Tile (stringList.get("BoardwalkField"),5, 8,0);

        // no color 0
        // brown 1
        // lightBlue 2
        // pink 3
        // orange 4
        // red 5
        // gold 6
        // green 7
        // blue 8

        tiles[0] = start;
        tiles[1] = theBurgerbar;
        tiles[2] = pizzeria;
        tiles[3] = chanceCard;
        tiles[4] = candyStore;
        tiles[5] = iceCreamKiosk;
        tiles[6] = visitPrison;
        tiles[7] = museum;
        tiles[8] = library;
        tiles[9] = chanceCard;
        tiles[10] = skatepark;
        tiles[11] = swimmingpool;
        tiles[12] = freeParking;
        tiles[13] = arcade;
        tiles[14] = cinema;
        tiles[15] = chanceCard;
        tiles[16] = toyStore;
        tiles[17] = petShop;
        tiles[18] = goPrison;
        tiles[19] = bowlingAlley;
        tiles[20] = zoo;
        tiles[21] = chanceCard;
        tiles[22] = waterPark;
        tiles[23] = boardwalk;


        return tiles;
    }

    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }

    public void setBalanceChange(int balanceChange) {
        this.balanceChange = balanceChange;
    }
    public int getBalanceChange() {
        return balanceChange;
    }

    public int getPropertyOwner() {
        return propertyOwner;
    }
    public void setPropertyOwner(int propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    /**
     * Makes the player got to the chosen color on the board.
     * @param color Color number
     * @return New position for player on a colored tile
     */
    public static int goToColor(int color){
        int position;
        position = 1+3*(color-1);
        return position;
    }

    /**
     * Doubles the rent of a tile, if both tiles are owned by the same player.
     * @param tiles The array of tiles
     * @return The rent of the property
     */
    public int getBalanceChangeExtra(Tile[] tiles){
        int newBalanceChange = balanceChange;
        if(propertyOwner != 0){
            for(int i = 1; i < tiles.length; i++){
                if((tiles[i].getColor() == color) && (tiles[i].propertyOwner == tiles[i-1].propertyOwner)){
                    newBalanceChange = balanceChange * 2;
                }
            }
        }
        return newBalanceChange;
    }

    /**
     * Checks if the property the player landed on is owned by another player. If the tile is not owned,
     * The player will buy the property
     * @param currentPlayerNumber The player number of the current player
     * @return A negative balance change
     */
    public int tileAvailable(int currentPlayerNumber){
        if(propertyOwner == 0){
            propertyOwner = currentPlayerNumber;

        }
        return -balanceChange;
    }

    public String getTileName() {
        return tileName;
    }


}
