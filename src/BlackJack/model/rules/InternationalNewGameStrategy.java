package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;  

class InternationalNewGameStrategy implements INewGameStrategy {

  @Override
  public boolean NewGame(Dealer a_dealer, Player a_player) {
	a_dealer.DealCardToPlayer(a_player, true);
	a_dealer.DealCardToPlayer(a_dealer, true);
	a_dealer.DealCardToPlayer(a_player, true);
  
    return true;
  }
}