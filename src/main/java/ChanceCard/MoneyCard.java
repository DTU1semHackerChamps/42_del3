package ChanceCard;
import monopoly_junior.Player;
import monopoly_junior.Tile;

public class MoneyCard {

    private int amount;

    public useMoneyCard(int amount) {
        this.amount = amount;
    }

    public void affect(Player currentPlayer, Player addBalance)
    {
        addBalance.addBalance(amount);
    }

}
