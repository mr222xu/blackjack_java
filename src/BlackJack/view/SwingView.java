package BlackJack.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import BlackJack.model.Card;
import BlackJack.model.rules.AmericanNewGameStrategy;
import BlackJack.model.rules.BasicHitStrategy;
import BlackJack.model.rules.DealerWinsOnEqualsWinStrategy;
import BlackJack.model.rules.InternationalNewGameStrategy;
import BlackJack.model.rules.PlayerWinsOnEqualsWinStrategy;
import BlackJack.model.rules.Soft17HitStrategy;

public class SwingView extends JFrame implements ActionListener,IView {

	private static final long serialVersionUID = -7329599708098073986L;
	
	// Members
	private JButton m_newGameBtn;
	private JButton m_hitBtn;
	private JButton m_standBtn;
	private JButton m_quitBtn;
	private JPanel m_playerPanel;
	private JPanel m_dealerPanel;
	private JPanel m_buttonsPanel;
	private JPanel m_messagesPanel;
	private JTextArea m_playerText;
	private JTextArea m_dealerText;
	private JTextArea m_messageText;
	private Input m_input;
	
	public SwingView() {
		super("Black Jack");
		
		// Create buttons
		m_newGameBtn = new JButton("New Game");
		m_hitBtn = new JButton("Hit");
		m_standBtn = new JButton("Stand");
		m_quitBtn = new JButton("Quit");
		
		// Create panels
		m_playerPanel = new JPanel();
		m_dealerPanel = new JPanel();
		m_buttonsPanel = new JPanel();
		m_messagesPanel = new JPanel();
		
		// Create text areas
		m_playerText = new JTextArea();
		m_dealerText = new JTextArea();
		m_messageText = new JTextArea();
		
		// Add listener to buttons
		m_newGameBtn.addActionListener(this);
		m_hitBtn.addActionListener(this);
		m_standBtn.addActionListener(this);
		m_quitBtn.addActionListener(this);
		
		// Add buttons to button panel
		m_buttonsPanel.add(m_newGameBtn);
		m_buttonsPanel.add(m_hitBtn);
		m_buttonsPanel.add(m_standBtn);
		m_buttonsPanel.add(m_quitBtn);
		
		// Setup text areas
		m_playerText.setRows(10);
		m_playerText.setColumns(10);
		m_playerText.setEditable(false);
		m_dealerText.setRows(10);
		m_dealerText.setColumns(10);
		m_dealerText.setEditable(false);
		m_messageText.setRows(10);
		m_messageText.setColumns(10);
		m_messageText.setEditable(false);
		m_messageText.setText("Hello Black Jack World");
		
		// Setup panels
		m_playerPanel.setLayout(new GridLayout(0,1));
		m_playerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		m_dealerPanel.setLayout(new GridLayout(0,1));
		m_dealerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		m_buttonsPanel.setLayout(new GridLayout(0,4));
		m_messagesPanel.setLayout(new GridLayout(0,1));
		m_messagesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// Add text areas to panels
		m_playerPanel.add(m_playerText);
		m_dealerPanel.add(m_dealerText);
		m_messagesPanel.add(m_messageText);
		
		// Disable hit and stand when game is not started
		m_hitBtn.setEnabled(false);
		m_standBtn.setEnabled(false);
		
		// Set input to unknown
		m_input = Input.UNKNOWN;
		
		// Setup window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,1));
        add(m_messagesPanel);
        add(m_dealerPanel);
        add(m_playerPanel);
        add(m_buttonsPanel);
        setSize(500, 350);
	}

	@Override
	public void DisplayWelcomeMessage() {
		// Display window
		setVisible(true);
	}

	@Override
	public void DisplayClearScreen() {
		//m_playerText.setText("");
		//m_dealerText.setText("");
		
		// Do nothing
	}

	@Override
	public Input GetInput() {
		// Just so that the play loop calms down
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// Do nothing
		}
		
		Input input = m_input;
		m_input = Input.UNKNOWN;
		
		return input;
	}

	@Override
	public void DisplayCard(Card a_card) {
		// Do nothing
	}

	@Override
	public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score) {
		DisplayHand("Player", m_playerText, a_hand, a_score);
	}

	@Override
	public void DisplayDealerHand(Iterable<Card> a_hand, int a_score) {
		DisplayHand("Dealer", m_dealerText, a_hand, a_score);
	}
	
	@Override
	public void DisplayGameOver(boolean a_dealerIsWinner) {
		JOptionPane.showMessageDialog(this,
				a_dealerIsWinner ? "Dealer Won!" : "You Won!",
			    "Game Over",
			    JOptionPane.PLAIN_MESSAGE);
		m_input = Input.NEW_GAME;
		m_playerText.setText("");
		m_dealerText.setText("");
	}
	
	private void DisplayHand(String a_name, JTextArea a_textArea, Iterable<BlackJack.model.Card> a_hand, int a_score) {
		a_textArea.setText(a_name + " has: ");
        for(BlackJack.model.Card c : a_hand)
        	a_textArea.append("\n" + c.GetValue() + " of " + c.GetColor());
        a_textArea.append("\nScore: " + a_score);
	}

	@Override
	public void visit(AmericanNewGameStrategy a_newGameStrategy) {
		m_messageText.append("\nNew Game Strategy: "+ a_newGameStrategy.getClass().getName());
	}

	@Override
	public void visit(BasicHitStrategy a_hitStrategy) {
		m_messageText.append("\nHit Strategy: "+ a_hitStrategy.getClass().getName());
	}

	@Override
	public void visit(DealerWinsOnEqualsWinStrategy a_winStrategy) {
		m_messageText.append("\nWin Strategy: "+ a_winStrategy.getClass().getName());
	}

	@Override
	public void visit(InternationalNewGameStrategy a_newGameStrategy) {
		m_messageText.append("\nNew Game Strategy: "+ a_newGameStrategy.getClass().getName());
	}

	@Override
	public void visit(PlayerWinsOnEqualsWinStrategy a_winStrategy) {
		m_messageText.append("\nWin Strategy: "+ a_winStrategy.getClass().getName());
	}

	@Override
	public void visit(Soft17HitStrategy a_hitStrategy) {
		m_messageText.append("\nHit Strategy: "+ a_hitStrategy.getClass().getName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(m_newGameBtn)) {
			m_hitBtn.setEnabled(true);
			m_standBtn.setEnabled(true);
			m_input = Input.NEW_GAME;
		} else if (e.getSource().equals(m_hitBtn)) {
			m_input = Input.HIT;
		} else if (e.getSource().equals(m_standBtn)) {
			m_input = Input.STAND;
		} else if (e.getSource().equals(m_quitBtn)) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
}
