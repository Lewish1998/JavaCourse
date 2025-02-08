
/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Dealer extends Player {

    private Hand hand;
    private boolean isBust;
    private boolean blackJack;


    public Dealer(String name) {
        super(name);
        this.hand = new Hand();
        this.isBust = false;
        this.blackJack = false;

    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return isBust;
    }

    public String getName() {
        return "Dealer";
    }

    public boolean hasBlackJack() {
        return this.blackJack;
    }

    public void setBlackJack(boolean blackJack) {
        this.blackJack = blackJack;
    }

    public void dealCard(Player player, Deck deck) {
        Card dealtCard = deck.getCard();
        player.addCardToHand(dealtCard);
    }

    @Override
    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }

    @Override
    public int getHandValue() {
        return this.hand.getHandValue();
    }

    public void startGame(Player player, Deck deck) {
        for (int i = 0; i < 2; i++) {
            dealCard(player, deck);
        }
        player.getHand().checkBlackJack(player);
    }

    @Override
    public String describeHand() {
        String handText = "\nDealer has ";
        for (Card card : this.hand.getCards()) {
            handText += "\n" + card.prettyName();
        }
        return handText;
    }

    public String describeFirstCard() {
        String firstCard = "\nDealer has " + this.hand.getCards().get(0).prettyName() + "\n";
        return firstCard;
    }

    public Card latestCard() {
        return this.hand.getCards().get(this.hand.getCards().size() - 1);
    }

    public void setBust(boolean bust) {
        this.isBust = bust;
    }

    public boolean checkAce() {
        for (Card card : this.hand.getCards()) {
            if (card.getRank().equals(Rank.ACE)) {
                return true;
            }
        }
        return false;
    }

    public void changeAceValue() {
        this.hand.changeAceValue();

    }
}
