
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestHand {

    Hand hand;
    Card card;
    Card card2;
    @Before
    public void setup(){
        hand = new Hand();
        card = new Card(Suit.CLUBS, Rank.JACK);
        card2 = new Card(Suit.DIAMONDS, Rank.ACE);
    }

    @Test
    public void valueIs0Initially(){
        assertEquals(0, hand.getHandValue());
    }

    @Test
    public void cardIsAdded(){
        hand.addCard(card);
        assertEquals(1, hand.getCards().size());
    }

    @Test
    public void handHasValue(){
        hand.addCard(card);
        assertEquals(10, hand.getHandValue());
    }

    @Test
    public void changeAceValue(){
        hand.addCard(card2);
        hand.changeAceValue();
        assertEquals(11, hand.getHandValue());
    }


}
