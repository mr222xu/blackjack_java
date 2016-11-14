package BlackJack.model.rules;

public interface IAbstractRulesFactory extends IStrategy {
	public IHitStrategy GetHitRule();
	public INewGameStrategy GetNewGameRule();
	public IWinStrategy GetWinRule();
}
