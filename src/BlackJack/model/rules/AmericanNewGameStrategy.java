package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;  

public class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {
    a_dealer.DealCardToPlayer(a_player, true);
	a_dealer.DealCardToPlayer(a_dealer, true);
	a_dealer.DealCardToPlayer(a_player, true);
	a_dealer.DealCardToPlayer(a_dealer, false);
	
    return true;
  }

	@Override
	public void accept(IVisitor a_visitor) {
		a_visitor.visit(this);
	}
}