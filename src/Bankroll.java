public class Bankroll {
    private int bankroll;

    public Bankroll(){

    }
    public void setBankroll(int money){
        bankroll = money; 
    }
    public int currentBankroll(){
        return(bankroll);
    }
    public boolean canAffordBet(int desiredbet){
        if (desiredbet > bankroll){
            return(false);
        }
        return(true);
    }
    public void lostHand(int bet){
        bankroll -= bet;
    }
    public void wonHand(int bet, boolean isBlackjack){
        bankroll += bet;
        if (isBlackjack == true){
            bankroll += (bet * 0.5);
        }
    }
}
