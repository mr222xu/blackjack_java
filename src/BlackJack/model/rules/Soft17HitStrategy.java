package BlackJack.model.rules;

import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
    	return (a_dealer.CalcScore() < g_hitLimit) ||
    			(a_dealer.CalcScore() == g_hitLimit && a_dealer.GotAce());  
    }

	@Override
	public void accept(IVisitor a_visitor) {
		a_visitor.visit(this);
	}
}
