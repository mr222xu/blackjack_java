package BlackJack.model.rules;

public class BasicAmericanDealerWinsRulesFactory extends AbstractRulesFactory {
	
	public BasicAmericanDealerWinsRulesFactory() {
		hitStrategy = new BasicHitStrategy();
		newGameStrategy = new AmericanNewGameStrategy();
		winStrategy = new DealerWinsOnEqualsWinStrategy();
	}
}
