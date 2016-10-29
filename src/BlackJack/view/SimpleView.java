package BlackJack.view;

import java.util.HashMap;
import java.util.Map;

public class SimpleView implements IView 
{
	
	private final Map<Integer, Input> input = new HashMap<Integer, Input>() {{
		put((int) 'p', Input.NEW_GAME);
		put((int) 'h', Input.HIT);
		put((int) 's', Input.STAND);
		put((int) 'q', Input.QUIT);
	}};

	public void DisplayClearScreen() {
		for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
	}
	
  public void DisplayWelcomeMessage()
        {
	  	  DisplayClearScreen();
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public Input GetInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return input.getOrDefault(c, Input.UNKNOWN);
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return Input.UNKNOWN;
          }
        }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
    }
