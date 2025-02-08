
import java.util.ArrayList;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Hand {

    private ArrayList<Card> cards;
    private int value;


    public Hand() {
        this.cards = new ArrayList<Card>();
        value = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
        this.value += card.getValue();
    }

    public int getHandValue(){
        return this.value;
    }

    public int getNumberOfCards(){
        return this.cards.size();
    }

    public void changeAceValue(){
        this.value  += 10;
    }


    public void checkBlackJack(Player player) {
        boolean face = false;
        if (player.checkAce()) {
            for (Card card : this.getCards()) {
                if (card.getRank().equals(Rank.JACK) || card.getRank().equals(Rank.QUEEN) || card.getRank().equals(Rank.KING)) {
                    face = true;
                }
            }
            player.setBlackJack(face);
        }
    }

}