package ChanceCard;

public class ChanceCard {
    private int balanceChange;
    private boolean movePlayer;
    private boolean exitPrison;
    private boolean FreeProperty;
    private boolean DrawExtraCard;
    private String CardDescription;

    public ChanceCard(int balanceChange, boolean movePlayer, boolean exitPrison, boolean FreeProperty, boolean DrawExtraCard, String CardDescription) {
        this.balanceChange = balanceChange;
        this.movePlayer = movePlayer;
        this.exitPrison = exitPrison;
        this.FreeProperty = FreeProperty;
        this.DrawExtraCard = DrawExtraCard;
        this.CardDescription = CardDescription;

    }

    public static int drawChanceCard(int[] sequence){
        int cardNumber = sequence[0];
        int cardsDrawed = 0;
        for(int i = 1; i < sequence.length; i++){
            sequence[i-1] = sequence[i];
        }
        chanceCards(cardNumber);
        cardsDrawed++;
        if (cardsDrawed > 20){
            cardsDrawed = 0;
        }

        return cardsDrawed;
    }

    public static void chanceCards(int cardNumber){
        switch(cardNumber){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;

        }
    }


    public static int[] ChanceCardArrayInit(){
        int[] sequence = new int[20];
        for(int i = 0; i < 20; i++){
            sequence[i] = i;
        }

        return sequence;
    }


}


