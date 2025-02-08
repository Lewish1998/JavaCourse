
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestPlayer {

    Player player;
    Card card;
    Card card2;

    @Before
    public void setup(){
        player = new Player("Ally");
        card = new Card(Suit.DIAMONDS, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.FOUR);
    }

    @Test
    public void playerHasName(){
        assertEquals("Ally", player.getName());
    }

    @Test
    public void playerCanTakeCard(){
        player.addCardToHand(card);
        assertEquals(1, player.getHand().getNumberOfCards());
    }

    @Test
    public void playerHandValueIs15(){
        player.addCardToHand(card);
        player.addCardToHand(card2);
        player.changeAceValue();
        assertEquals(15, player.getHandValue());
    }
}
