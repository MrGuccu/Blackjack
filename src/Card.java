public class Card {
    private String suit;
    private String rank;
    private int value;

    public Card(String cardsuit, String cardrank){
        suit = cardsuit;
        rank = cardrank; 
        switch (rank){
            case "Two":
                value = 2;
                break;
            case "Three":
                value = 3;
                break;
            case "Four":
                value = 4;
                break;
            case "Five":
                value = 5;
                break;
            case "Six":
                value = 6;
                break;
            case "Seven":
                value = 7;
                break;
            case "Eight":
                value = 8;
                break;
            case "Nine":
                value = 9;
                break;
            case "Ten":
            case "Jack":
            case "Queen":
            case "King":
                value = 10;
                break;
            case "Ace":
                value = 11;
        }
    }
    public String getSuit(){
        return(suit);
    }
    public String getRank(){
        return(rank);
    }
    public int getValue(){
        return(value);
    }
    public String printCard(){
        return(rank + " of " + suit);
    }
}
