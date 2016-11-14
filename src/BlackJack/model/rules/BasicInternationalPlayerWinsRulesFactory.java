package BlackJack.model.rules;

public class BasicInternationalPlayerWinsRulesFactory extends AbstractRulesFactory {
	
	public BasicInternationalPlayerWinsRulesFactory() {
		hitStrategy = new BasicHitStrategy();
		newGameStrategy = new InternationalNewGameStrategy();
		winStrategy = new PlayerWinsOnEqualsWinStrategy();
	}
}
