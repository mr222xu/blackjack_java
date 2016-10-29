package BlackJack.controller;

import BlackJack.model.Dealer;
import BlackJack.model.Game;
import BlackJack.model.IObserver;
import BlackJack.model.Player;
import BlackJack.view.IView;
import BlackJack.view.Input;

public class PlayGame implements IObserver {
	
	private Game m_game;
	private IView m_view;
  
	public PlayGame(Game a_game, IView a_view) {
		m_game = a_game;
		m_view = a_view;
		m_game.AddObserver(this);
	}

  public boolean Play() {
    m_view.DisplayWelcomeMessage();
    
    m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
    m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

    if (m_game.IsGameOver()) {
        m_view.DisplayGameOver(m_game.IsDealerWinner());
    }

    Input input = m_view.GetInput();
    
    if (input == Input.NEW_GAME)
    {
        m_game.NewGame();
    }
    else if (input == Input.HIT)
    {
        m_game.Hit();
    }
    else if (input == Input.STAND)
    {
        m_game.Stand();
    }

    return input != Input.QUIT;
  }

	@Override
	public void Update(Player a_player) {
		m_view.DisplayClearScreen();
		
		if (a_player instanceof Dealer) {
			m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		} else {
			m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
		}
		
		// Sleep
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// Do nothing
		}
	}
}