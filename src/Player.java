import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    public Player(){
    }
    private void addCard(Card card) {
        hand.add(card);
    }
    public void dealHand(Deck deck) {
        // Add two cards to the player's hand
        addCard(deck.removeTopCard());
        addCard(deck.removeTopCard());
    }
    public void hitHand(Deck deck) {
        // Add the card to the player's hand
        addCard(deck.removeTopCard());
    }
    public void printHand(){
        for (int t = 0; t < hand.size(); t++){
            System.out.println(hand.get(t).printCard());
        }
    }
    private int aceCount(){
        int count = 0;
        for (int t = 0; t < hand.size(); t++){
            if (hand.get(t).getRank().equals("Ace")){
                count++;
            }
        }
        return(count);
    }
    public int getNumericScore(){
        int sum = 0;
        for (int t = 0; t < hand.size(); t++){
            sum += hand.get(t).getValue();
        }
        if (sum > 21 && aceCount() > 0){
            for (int t= 0 ; t< aceCount(); t++){
                sum -= 10;
            }
        }
        return(sum);
    }
    public boolean hasBlackjack(){
        if (hand.size() == 2 && getNumericScore() == 21){
            return(true);
        }
        return(false);
    }
    public ArrayList<Card> returnHand(){
        return(hand);
    }
    public void clearHand(){
        hand.clear();
    }
}
