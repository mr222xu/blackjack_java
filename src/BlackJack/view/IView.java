package BlackJack.view;

import BlackJack.model.rules.IVisitor;

public interface IView extends IVisitor
{	
	void DisplayWelcomeMessage();
	void DisplayClearScreen();
	Input GetInput();
	void DisplayCard(BlackJack.model.Card a_card);
	void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
	void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
	void DisplayGameOver(boolean a_dealerIsWinner);
}