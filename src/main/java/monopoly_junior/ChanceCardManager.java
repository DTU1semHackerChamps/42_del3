package monopoly_junior;

import ChanceCard.*;
import gui_main.GUI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


public class ChanceCardManager {

    public static ChanceCard[] cardArrayInit(HashMap<String, String > stringList, Tile[] tiles, Player[] players, Player currentPlayer, GUI gui) {
        ChanceCard[] chanceCards = new ChanceCard[14];

        chanceCards[0] = new moveMoneyCard(stringList.get("ChanceCard2"), tiles, players, currentPlayer, gui, 2, 0, true,false);
        chanceCards[1] = new specificMoveCard(stringList.get("ChanceCard3"), tiles, players, currentPlayer, gui);
        chanceCards[2] = new ColorCard(stringList.get("ChanceCard4"), tiles, players, currentPlayer, gui, 4, stringList.get("ColorOrange"));
        chanceCards[3] = new moveMoneyCard(stringList.get("ChanceCard7"), tiles, players, currentPlayer, gui, -2, 0, false,false);
        chanceCards[4] = new ChooseColorCard(stringList.get("ChanceCard8"), tiles, players, currentPlayer, gui, 4,7, stringList.get("ColorOrange"), stringList.get("ColorGreen"));
        chanceCards[5] = new ColorCard(stringList.get("ChanceCard9"), tiles, players, currentPlayer, gui, 2, stringList.get("ColorLightblue"));
        chanceCards[6] = new JailCard(stringList.get("ChanceCard10"), tiles, players, currentPlayer, gui);
        chanceCards[7] = new moveMoneyCard(stringList.get("ChanceCard11"), tiles, players, currentPlayer, gui, 0, 23, true, false);
        chanceCards[8] = new ChooseColorCard(stringList.get("ChanceCard15"), tiles, players, currentPlayer, gui, 3, 8, stringList.get("ColorPink"), stringList.get("ColorDarkblue"));
        chanceCards[9] = new moveMoneyCard(stringList.get("ChanceCard16"), tiles, players, currentPlayer, gui, 2, 0, false,false );
        chanceCards[10] = new moveMoneyCard(stringList.get("ChanceCard17"), tiles, players, currentPlayer, gui, tiles[10].getBalanceChangeExtra(tiles), 10, true, true);
        chanceCards[11] = new ColorCard(stringList.get("ChanceCard18"), tiles, players, currentPlayer, gui, 9, stringList.get("SkateparkField"));
        chanceCards[12] = new ChooseColorCard(stringList.get("ChanceCard19"), tiles, players, currentPlayer, gui, 2, 5, stringList.get("ColorLightblue"), stringList.get("ColorRed"));
        chanceCards[13] = new ChooseColorCard(stringList.get("ChanceCard20"), tiles, players, currentPlayer, gui, 1, 6, stringList.get("ColorBrown"), stringList.get("ColorYellow"));

        return chanceCards;
    }

    public static void cardShuffle(ChanceCard[] cardList){

        int index;
        ChanceCard temp;
        Random random = new Random();
        for (int i = cardList.length - 1; i >= 0; i--)
        {
            index = random.nextInt(i+1);
            temp = cardList[index];
            cardList[index] = cardList[i];
            cardList[i] = temp;
            System.out.println(cardList[i]);
        }

    }

    public static int drawCard(int index, ChanceCard[] chanceCards, Player currentPlayer){
        for (int i = 0; i < chanceCards.length; i++) {
            chanceCards[i].setCurrentPlayer(currentPlayer);
        }

        index++;

        chanceCards[index].useChanceCard();


        if(index > 20){
            index = 0;
        }

        return index;
    }


}
