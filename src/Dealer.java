import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand = new ArrayList<Card>();
    boolean showhole = false;
    public Dealer(){
    
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
        if (showhole == false){
            System.out.println(hand.get(0).printCard());
            System.out.println("[Hole Card]");
        }
        else{
            for (int t = 0; t < hand.size(); t++){
                System.out.println(hand.get(t).printCard());
            }
        }
    }
    public void showHole(boolean choice){
        showhole = choice;
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
    public ArrayList<Card> returnHand(){
        return(hand);
    }
    public void clearHand(){
        hand.clear();
    }
}
