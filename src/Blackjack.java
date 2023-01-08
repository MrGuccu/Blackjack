import java.util.Scanner;

public class Blackjack {
    static Scanner scan = new Scanner(System.in);
        static Deck deck = new Deck(6);
        static Player player = new Player();
        static Dealer dealer = new Dealer();
        static Bankroll bankroll = new Bankroll();
    public static void main(String[] args) throws InterruptedException{
        deck.shuffleCards();
        System.out.println("Welcome to Blackjack! How many dollars in chip would you like to buy?");
        bankroll.setBankroll(scan.nextInt());
        while (true){
            playBlackjack();
            System.out.println("Remaining bankroll:" + bankroll.currentBankroll());
            deck.addDiscardCards(player.returnHand());
            player.clearHand();
            deck.addDiscardCards(dealer.returnHand());
            dealer.clearHand();
            dealer.showHole(false);
        }
    } 
    public static void playBlackjack() throws InterruptedException{
        int bet;
        String response;
        System.out.println("How much would you like to bet?");
        bet = scan.nextInt();
        if (bankroll.canAffordBet(bet) == false){
            System.out.println("You can't afford that bet.");
            return;
        }
        player.dealHand(deck);
        dealer.dealHand(deck);
        printTable();
        if (player.getNumericScore() == 21){    //Has Blackjack
            System.out.println("Blackjack!");
           bankroll.wonHand(bet, true); 
           return;
        }
        while (true){
            System.out.println("Hit or Stand?");
            response = scan.next();
            if (response.equalsIgnoreCase("hit")){
                player.hitHand(deck);
                printTable();
                if (player.getNumericScore() > 21){
                    System.out.println("Sorry, you bused!");
                    bankroll.lostHand(bet);
                    return;
                }
            }
            else{
                dealer.showHole(true);
                printTable();
                if (dealer.getNumericScore() > player.getNumericScore()){
                    System.out.println("Sorry, you lost!");
                        bankroll.lostHand(bet);
                        return;
                }
                else{
                    while (dealer.getNumericScore() < 17){
                        dealer.hitHand(deck);
                        printTable();
                        if (dealer.getNumericScore() > 21){
                            System.out.println("The dealer busted! You win!");
                            bankroll.wonHand(bet, false);
                            return;
                        }
                    }
                    if (dealer.getNumericScore() < player.getNumericScore()){
                        System.out.println("You have a better hand, you win!");
                        bankroll.wonHand(bet, false);
                        return;
                    }
                    else if(dealer.getNumericScore() > player.getNumericScore()){
                        System.out.println("I have a better hand, you lost!");
                        bankroll.lostHand(bet);
                        return;
                    }
                    else{
                        System.out.println("We have the same hand. Push.");
                        return;
                    }
                }
            }
        }
    }
    public static void printTable() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println();
        System.out.println("Dealer cards:");
        dealer.printHand();
        if (dealer.showhole == true){
            System.out.println(dealer.getNumericScore());
        }
        System.out.println();
        System.out.println("Your hand:");
        player.printHand();
        System.out.println(player.getNumericScore());
    }  
}
