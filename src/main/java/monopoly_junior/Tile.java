package monopoly_junior;

import java.io.IOException;
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

    public String getTileName() {
        return tileName;
    }

    /**
     * array of tile list
     * @return returns array of the specified initiated tiles
     */
    static HashMap<String,String> stringList;

    static {
        try {
            stringList = Language.languageInit("english");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Tile [] tileListInit(){
        Tile [] tiles = new Tile[24];
        Tile start = new Tile (stringList.get("StartField"),2,0,0);
        Tile burgerbaren = new Tile (stringList.get("BurgerbarField"), -1,1,0);
        Tile pizzeriaet = new Tile (stringList.get("PizzeriaField"), -1, 1,0);
        Tile chanceKort = new Tile (stringList.get("ChanceCardField"), 0,0,0);
        Tile slikButikken = new Tile (stringList.get("CandyStoreField"), -1,2,0);
        Tile isKiosken = new Tile (stringList.get("IceCreamField"), -1, 2,0);
        Tile visitPrison = new Tile (stringList.get("VisitJailField"), 0,0,0);
        Tile museet = new Tile (stringList.get("MuseumField"), -2,3,0);
        Tile biblioteket = new Tile (stringList.get("LibraryField"), -2,3,0);
        Tile skaterparken = new Tile (stringList.get("SkateparkField"), -2,4,0);
        Tile swimmingpoolen = new Tile (stringList.get("PoolField"),-2,4,0);
        Tile gratisParking = new Tile (stringList.get("FreeparkingField"),0,0,0);
        Tile spillehallen = new Tile (stringList.get("ArcadeField"), -3, 5,0);
        Tile biografen = new Tile (stringList.get("CinemaField"), -3, 5,0);
        Tile toyStore = new Tile (stringList.get("ToyStoreField"), -3,6,0);
        Tile dyrehandlen = new Tile (stringList.get("PetShopField"), -3, 6,0);
        Tile goPrison = new Tile (stringList.get("JailField"), 0, 0,0);
        Tile bowlinghallen = new Tile (stringList.get("BowlingAlleyField"), -4,7,0);
        Tile zoo = new Tile (stringList.get("ZooField"), -4, 7,0);
        Tile vandlandet = new Tile (stringList.get("WaterParkField"), -5, 8,0);
        Tile strandpromenaden = new Tile (stringList.get("BoardwalkField"),-5, 8,0);

        // no color 1
        // brown 2
        // lightBlue 3
        // pink 4
        // orange 5
        // red 6
        // gold 7
        // green 8

        tiles[0] = start;
        tiles[1] = burgerbaren;
        tiles[2] = pizzeriaet;
        tiles[3] = chanceKort;
        tiles[4] = slikButikken;
        tiles[5] = isKiosken;
        tiles[6] = visitPrison;
        tiles[7] = museet;
        tiles[8] = biblioteket;
        tiles[9] = chanceKort;
        tiles[10] = skaterparken;
        tiles[11] = swimmingpoolen;
        tiles[12] = gratisParking;
        tiles[13] = spillehallen;
        tiles[14] = biografen;
        tiles[15] = chanceKort;
        tiles[16] = toyStore;
        tiles[17] = dyrehandlen;
        tiles[18] = goPrison;
        tiles[19] = bowlinghallen;
        tiles[20] = zoo;
        tiles[21] = chanceKort;
        tiles[22] = vandlandet;
        tiles[23] = strandpromenaden;


        return tiles;
    }
}
