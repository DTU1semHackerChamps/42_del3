package monopoly_junior;

import java.util.HashMap;

public class Tile {


    /**
     * constructor
     */
    private int balanceChange;
    private String tileName;
    private String propertyPrice;
    public String propertyOwner;
    private int color;




    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Tile(String name,int balanceChange,int color)
    {
        this.balanceChange = balanceChange;
        this.tileName = name;
        this.color = color;
    }



    public void setBalanceChange(int balanceChange) {
        this.balanceChange = balanceChange;
    }
    public int getBalanceChange() {
        return balanceChange;
    }




    public String getTileName() {
        return tileName;
    }

    /**
     * array of tile list
     * @return returns array of the specified initiated tiles
     */
    public static Tile [] tileListInit(){
        Tile [] tiles = new Tile[24];
        Tile start = new Tile ("START",2,1);
        Tile burgerbaren = new Tile ("BURGERBAREN", -1,2);
        Tile pizzeriaet = new Tile ("PIZZERIAET", -1, 2);
        Tile chanceKort = new Tile ("CHANCE", 0,1);
        Tile slikButikken = new Tile ("SLIKBUTIKKEN", -1,3);
        Tile isKiosken = new Tile ("ISKIOSKEN", -1, 3);
        Tile visitPrison = new Tile ("PÅ BESØG I FÆNGSEL", 0,1);
        Tile museet = new Tile ("MUSEET", -2,4);
        Tile biblioteket = new Tile ("BIBLIOTEKET", -2,4);
        Tile skaterparken = new Tile ("SKATERPARKEN", -2,5);
        Tile swimmingpoolen = new Tile ("SWIMMINGPOOLEN",-2,5);
        Tile gratisParking = new Tile ("GRATIS PARKING",0,1);
        Tile spillehallen = new Tile ("SPILLEHALLEN", -3, 6);
        Tile biografen = new Tile ("BIOGRAFEN", -3, 6);
        Tile toyStore = new Tile ("LEGTØJSBUTIKKEN", -3,7);
        Tile dyrehandlen = new Tile ("DYREHANDLEN", -3, 7);
        Tile goPrison = new Tile ("GÅ I FÆNGSEL", 0, 1);
        Tile bowlinghallen = new Tile ("BOWLINGHALLEN", -4, 8);
        Tile zoo = new Tile ("ZOO", -4, 8);
        Tile vandlandet = new Tile ("VANDLANDET", -5, 9);
        Tile strandpromenaden = new Tile ("STRANDPROMENADEN",-5, 9);

        // no color 1
        // brown 2
        // lightBlue 3
        // pink 4
        // orange 5
        // red 6
        // gold 7
        // green 8
        // blue 9

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
