package BlackJack.model;

import BlackJack.model.rules.IAbstractRulesFactory;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.IWinStrategy;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winRule;


  public Dealer(IAbstractRulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      Card c;
      c = m_deck.GetCard();
      c.Show(true);
      a_player.DealCard(c);
      
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    /*if (a_player.CalcScore() > g_maxScore) {
      return true;
    } else if (CalcScore() > g_maxScore) {
      return false;
    }
    return CalcScore() >= a_player.CalcScore();*/
	  
	return m_winRule.IsDealerWinner(this, a_player, g_maxScore);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  public void DealCardToPlayer(Player a_player, boolean visible) {
    Card c = m_deck.GetCard();
	c.Show(visible);
	a_player.DealCard(c);
  }
  
  public boolean Stand() {
	  if (m_deck == null)
		  return false;
	  
	  ShowHand();
	  
	  while (m_hitRule.DoHit(this)) {
		  Card card = m_deck.GetCard();
		  card.Show(true);
		  
		  DealCard(card);
	  }
	  
	  return true;
  }
}