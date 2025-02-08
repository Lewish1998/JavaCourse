
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestDeck {
    private Deck deck;
    private Deck spyDeck;

    @Before
    public void setup(){
        deck = new Deck();
    }


    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void deckIsShuffled(){
        Deck deck2 = new Deck();
        assertFalse(deck.equals(deck2));
    }

    @Test
    public void canGetCard() {
        Card card = deck.getCard();
        assertNotNull(card);
    }
}
