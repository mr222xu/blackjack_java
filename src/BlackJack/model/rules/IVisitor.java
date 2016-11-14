package BlackJack.model.rules;

public interface IVisitor {
	public void visit(AmericanNewGameStrategy a_newGameStrategy);
	public void visit(BasicHitStrategy a_hitStrategy);
	public void visit(DealerWinsOnEqualsWinStrategy a_winStrategy);
	public void visit(InternationalNewGameStrategy a_newGameStrategy);
	public void visit(PlayerWinsOnEqualsWinStrategy a_winStrategy);
	public void visit(Soft17HitStrategy a_hitStrategy);
}
