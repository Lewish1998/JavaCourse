
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestDealer {

    Dealer dealer;
    Deck deck;
    Card card1;
    Card card2;

    @Before
    public void setup(){
        deck = new Deck();
        dealer = new Dealer("Dealer");
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.CLUBS, Rank.QUEEN);
    }

    @Test
    public void dealerCanDeal(){
        dealer.dealCard(dealer, deck);
        assertEquals(1, dealer.getHand().getNumberOfCards());

    }

    @Test
    public void dealerHasAce(){
        dealer.getHand().addCard(card1);
        assertEquals(true, dealer.checkAce());
    }

    @Test
    public void testBlackJack(){
        dealer.getHand().addCard(card1);
        dealer.getHand().addCard(card2);
        dealer.getHand().checkBlackJack(dealer);
        assertEquals(true, dealer.hasBlackJack());
    }

}
