package BlackJack.model.rules;

/**
 * Abstract implementation of IAbstractRulesFactory to minimize
 * code duplication.
 * 
 * @author mr222xu
 *
 */
public abstract class AbstractRulesFactory implements IAbstractRulesFactory {

	protected IHitStrategy hitStrategy;
	protected INewGameStrategy newGameStrategy;
	protected IWinStrategy winStrategy;
	
	public AbstractRulesFactory() {
		// Empty constructor
	}

	@Override
	public IHitStrategy GetHitRule() {
		return hitStrategy;
	}

	@Override
	public INewGameStrategy GetNewGameRule() {
		return newGameStrategy;
	}

	@Override
	public IWinStrategy GetWinRule() {
		return winStrategy;
	}
	
	@Override
	public void accept(IVisitor a_visitor) {
		hitStrategy.accept(a_visitor);
		newGameStrategy.accept(a_visitor);
		winStrategy.accept(a_visitor);
	}
}
