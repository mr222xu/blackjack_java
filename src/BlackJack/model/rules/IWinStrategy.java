package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinStrategy extends IStrategy {

	public boolean IsDealerWinner(Dealer a_dealer, Player a_player, int a_maxScore);
}
