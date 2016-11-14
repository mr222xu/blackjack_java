package BlackJack;

import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.model.rules.BasicAmericanDealerWinsRulesFactory;
import BlackJack.model.rules.IAbstractRulesFactory;
import BlackJack.view.IView;
import BlackJack.view.SimpleView;

public class Program
{

  public static void main(String[] a_args)
  {
	IView v = new SimpleView(); //new SwedishView();
	IAbstractRulesFactory r = new BasicAmericanDealerWinsRulesFactory();
    Game g = new Game(r);
    r.accept(v); // Will print info about which rules are in use
                 // Note that in the SimpleView case it will be in the top of the execution output, i.e. 
                 // there might be quite a lot of newlines after the output so it might not be visible.
    PlayGame ctrl = new PlayGame(g, v);
    
    while (ctrl.Play());
  }
}