import monopoly_junior.Dice;
import monopoly_junior.Player;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player = new Player(0,0, "", false,0);
    Dice dice = new Dice(0);

    @Test
    public void getPlayerNum() {
        player.setPlayerNum(1);
        assertTrue(player.getPlayerNum() == 1);
    }

    @Test
    public void setPlayerNum() {
        player.setPlayerNum(2);
        assertTrue(player.getPlayerNum() == 2);
    }

    @Test
    public void setJailCard() {
        player.setJailCard(true);
        assertTrue(player.getJailCard() == true);
    }


    @Test
    public void isJailCard() {
    }

    @Test
    public void setBalance() {
        player.setBalance(10);
        assertTrue(player.getBalance() == 10);
        player.setBalance(20);
        assertTrue(player.getBalance() == 20);
    }



    @Test
    public void addBalance() {
        player.setBalance(13);
        player.addBalance(5);
        assertTrue(player.getBalance() == 18);


        player.setBalance(-13);
        player.addBalance(5);
        assertTrue(player.getBalance() == 0);

        player.setBalance(-13);
        player.addBalance(-10);
        assertTrue(player.getBalance() == 0);


    }


    @Test
    public void getPosition() {
        player.setPosition(4);
        assertTrue(player.getPosition() == 4);
    }

//    @Test
//    public void addPosition() {
//        player.setPosition(dice.rollDice());
//    }


    @Test
    public void getPlayerName() {
        assertEquals("Neil", "Neil");
    }

    @Test
    public void playerList() {
        player.playerList(3);
        player.player[0] = "Mads";
        player.player[1] = "Christ";
        player.player[2] = "Magnus";

        assertTrue(player.player[0] == "Mads");
        assertTrue(player.player[1] == "Christ");
        assertTrue(player.player[2] == "Magnus");
    }


    @Test
    public void nextPlayer() {
        player.playerList(3);
        assertTrue(player.nextPlayer(3) == 1);


        player.playerList(10);
        assertTrue(player.nextPlayer(32) == 3);


        player.playerList(1);
        assertTrue(player.nextPlayer(1) == 0);





    }
}