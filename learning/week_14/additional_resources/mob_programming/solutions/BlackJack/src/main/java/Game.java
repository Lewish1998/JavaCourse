
import java.util.ArrayList;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Game {

    private Deck deck;
    private Dealer dealer;
    private Player player;

    public Game(Deck deck, Player player) {
        this.deck = deck;
        this.dealer = new Dealer("Dealer");
        this.player = player;
    }


    public void play() {
        dealer.startGame(this.dealer, this.deck);
        dealer.startGame(this.player, this.deck);
        if (this.dealer.hasBlackJack() || this.player.hasBlackJack()){
            checkWinner();
        }
        if (this.player.checkAce()) {

                this.player.changeAceValue();
        }
        stickOrTwist();
        dealerPlay();

    }



    private void stickOrTwist(){
        while (!this.player.isBust() && this.player.getHandValue() < 16 ) {
            twist(this.player);
        }
    }

    private void twist(Player player){
        dealer.dealCard(player, this.deck);

    }

    private boolean checkBust(Player player){
        if (player.getHandValue() > 21){
            player.setBust(true);
        }
        return player.isBust();
    }

    public void dealerPlay(){
        if(this.dealer.checkAce() && this.dealer.getHandValue() < 10) {
            this.dealer.changeAceValue();
        }
        if(this.dealer.getHandValue() < 16){
            this.dealer.dealCard(this.dealer, this.deck);
            if(checkBust(this.dealer)){

            } else{
                dealerPlay();
            }
        } else {
            checkWinner();
        }
    }


    public Player checkWinner(){
        if ((this.dealer.getHandValue() == this.player.getHandValue()) || (this.dealer.hasBlackJack() && this.player.hasBlackJack())){
            return null;
        }
        if (this.dealer.getHandValue() < this.player.getHandValue() || player.hasBlackJack()){
            return this.player;
        } else {
            return this.dealer;
        }
    }
}
