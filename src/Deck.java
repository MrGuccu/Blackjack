import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private int deckCount;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Card> discardedcards = new ArrayList<Card>();

    String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven","Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    public Deck(int NumberOfDecks){
        deckCount = NumberOfDecks;
        for (int n = 0; n < deckCount; n++){
            for (int s = 0; s < 4; s++){
                for (int r = 0; r < 13; r++){
                    Card card = new Card(suits[s],ranks[r]);
                    cards.add(card);
                }
            }
        }
    }
    public void shuffleCards(){
        Collections.shuffle(cards);
    }
    public Card removeTopCard(){
        return cards.remove(0);
    }
    public void addDiscardCards(ArrayList<Card> list){
        for (int t = 0; t < list.size(); t++){
            discardedcards.add(list.get(t));
        }
    }
}
