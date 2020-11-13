package monopoly_junior;

import java.util.HashMap;

public class Tile {
    /**
     * constructor
     */
    private int balanceChange;


    private String tileName;
    public Tile(String name,int balanceChange)
    {
        this.balanceChange = balanceChange;
        this.tileName = name;



    }


    public void setBalanceChange(int balanceChange) {
        this.balanceChange = balanceChange;
    }





    public String getTileName() {
        return tileName;
    }

    /**
     * array of tile list
     * @return returns array of the specified initiated tiles
     */
    public static Tile [] tileListInit(HashMap<String,String> stringList){
        Tile [] tiles = new Tile[24];
        Tile start = new Tile ("START",2);
        Tile burgerbaren = new Tile ("BURGERBAREN", -1);
        Tile pizzeriaet = new Tile ("PIZZERIAET", -1);
        Tile chanceKort1 = new Tile ("CHANCE", 0);
        Tile slikbutikken = new Tile ("SLIKBUTIKKEN", -1);
        Tile iskiosken = new Tile ("ISKIOSKEN", -1);
        Tile visitPrison = new Tile ("PÅ BESØG I FÆNGSEL", 0);
        Tile museet = new Tile ("MUSEET", -2);
        Tile biblioteket = new Tile ("BIBLIOTEKET", -2);
        Tile chanceKort2 = new Tile ("CHANCE", 0);
        Tile skaterparken = new Tile ("SKATERPARKEN", -2);
        Tile swimmingpoolen = new Tile ("SWIMMINGPOOLEN",-2);
        Tile gratisParking = new Tile ("GRATIS PARKING",0);
        Tile spillehallen = new Tile ("SPILLEHALLEN", -3);
        Tile biografen = new Tile ("BIOGRAFEN", -3);
        Tile chanceKort3 = new Tile ("CHANCE", 0);
        Tile legtøjsbutikken = new Tile ("LEGTØJSBUTIKKEN", -3);
        Tile dyrehandlen = new Tile ("DYREHANDLEN", -3);
        Tile gaaIFængsel = new Tile ("GÅ I FÆNGSEL", 0);
        Tile bowlinghallen = new Tile ("BOWLINGHALLEN", -4);
        Tile zoo = new Tile ("ZOO", -4);
        Tile chanceKort4 = new Tile ("CHANCE", 0);
        Tile vandlandet = new Tile ("VANDLANDET", -5);
        Tile strandpromenaden = new Tile ("STRANDPROMENADEN",-5);
        //

        tiles[1] = start;
        tiles[2] = burgerbaren;
        tiles[3] = pizzeriaet;
        tiles[4] = chanceKort1;
        tiles[5] = slikbutikken;
        tiles[6] = iskiosken;
        tiles[7] = visitPrison;
        tiles[8] = museet;
        tiles[9] = biblioteket;
        tiles[10] = chanceKort2;
        tiles[11] = skaterparken;
        tiles[12] = swimmingpoolen;
        tiles[13] = gratisParking;
        tiles[14] = spillehallen;
        tiles[15] = biografen;
        tiles[16] = chanceKort3;
        tiles[17] = legtøjsbutikken;
        tiles[18] = dyrehandlen;
        tiles[19] = gaaIFængsel;
        tiles[20] = bowlinghallen;
        tiles[21] = zoo;
        tiles[22] = chanceKort4;
        tiles[23] = vandlandet;
        tiles[24] = strandpromenaden;


        return tiles;
    }
}
