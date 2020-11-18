package ChanceCard;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class FreeProperty {
    // gratis felt nr: 4. 8. 9. 15. 17. 18. 19. 20.
    // 4 - orange felt
    // 8 - orange eller grøn felt
    // 9 - lyseblåt felt
    // 15 - pink eller mørkeblåt felt
    // 17 - rødt felt
    // 18 - skaterparken
    // 19 - lyseblåt eller rødt felt
    // 20 - brunt eller gult felt

    protected String name;
    protected int movePlayer;
    protected int payRent;
    public static void freeProperty;

    public FreeProperty(String name, int movePlayer, int payRent) {
        this.name = name;
        this.movePlayer = movePlayer;
        this.payRent = payRent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovePlayer() {
        return movePlayer;
    }

    public void setMovePlayer(int movePlayer) {
        this.movePlayer = movePlayer;
    }

    public int getPayRent() {
        return payRent;
    }

    public void setPayRent(int payRent) {
        this.payRent = payRent;
    }

}
}
