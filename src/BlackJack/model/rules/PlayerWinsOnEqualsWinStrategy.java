package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class PlayerWinsOnEqualsWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(Dealer a_dealer, Player a_player, int a_maxScore) {
		if (a_player.CalcScore() > a_maxScore) {
			return true;
		} else if (a_dealer.CalcScore() > a_maxScore) {
			return false;
		}
		
		return a_dealer.CalcScore() > a_player.CalcScore();
	}

}
