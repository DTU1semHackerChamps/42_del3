package monopoly_junior;

import ChanceCard.*;
import gui_main.GUI;

import java.io.IOException;
import java.util.HashMap;


public class ChanceCardManager {

    public static ChanceCard[] cardArrayInit(Player currentPlayer, GUI gui, int newPosition, boolean positionSwitch) throws IOException {
        ChanceCard[] chanceCards = new ChanceCard[12];
        HashMap<String,String> stringList = Language.languageInit("english");

        //chanceCards[0] = new CharacterCard;
        //chanceCards[1] = new MoveCard();
        chanceCards[2] = new specificMoveCard(stringList.get("ChanceCard3"), null, null, currentPlayer, gui);
        //chanceCards[3] = new ColorCard(stringList.get("ChanceCard4"), null, null, currentPlayer, gui);
        //chanceCards[4] = new [1 skridt eller et kort metode](stringList.get("ChanceCard5"), null, null, currentPlayer, gui);
        //chanceCards[5] = new CharacterCard(stringList.get("ChanceCard6"), null, null, currentPlayer, gui);
        chanceCards[6] = new moveMoneyCard(stringList.get("ChanceCard7"), null, null, currentPlayer, gui, 2, 0, false);
        chanceCards[7] = new ChooseColorCard(stringList.get("ChanceCard8"), null, null, currentPlayer, gui, 4,7, stringList.get("ColorOrange"), stringList.get("ColorGreen"));
        //chanceCards[8] = new ColorCard(stringList.get("ChanceCard9"), null, null, currentPlayer, gui);
        chanceCards[9] = new JailCard(stringList.get("ChanceCard10"), null, null, currentPlayer, gui);
        chanceCards[10] = new moveMoneyCard(stringList.get("ChanceCard11"), null, null, currentPlayer, gui, 0, 23, true);
        //chanceCards[11] = new CharacterCard(stringList.get("ChanceCard12"), null, null, currentPlayer, gui);
        //chanceCards[12] = new CharacterCard(stringList.get("ChanceCard13"), null, null, currentPlayer, gui);
        //chanceCards[13] = new BirthdayCard(stringList.get("ChanceCard14"), null, null, currentPlayer, gui);






    }

    public static void cardShuffle(){

    }

    public static int drawCard(){

        return card;
    }


}
