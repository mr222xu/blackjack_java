package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class DealerWinsOnEqualsWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(Dealer a_dealer, Player a_player, int a_maxScore) {
		if (a_player.CalcScore() > a_maxScore) {
			return true;
		} else if (a_dealer.CalcScore() > a_maxScore) {
			return false;
		}
		
		return a_dealer.CalcScore() >= a_player.CalcScore();
	}

	@Override
	public void accept(IVisitor a_visitor) {
		a_visitor.visit(this);
	}
}
