package domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import domain.die.Cup;

public class GameController {

	private Board board;
	private Cup cup;
	private List<Player> players;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;

	// contain a support object instead of extending the support class
	private PropertyChangeSupport pcs;

	public GameController() {
		board = new Board();
		pcs = new PropertyChangeSupport(this);
		cup = new Cup();
		players = new ArrayList<>();
	}

	public void addObserver(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void addObserverToProperty(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	public void playTurn() {
		cup.rollDices();
		if (!cup.isDouble()) {
			this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			setCurrentPlayer(currentPlayerIndex);
		}
	}

	private void setCurrentPlayer(int index) {
		Player currentPlayer = players.get(index);
		if (currentPlayer.equals(this.currentPlayer))
			return;
		Player old = this.currentPlayer;
		this.currentPlayer = currentPlayer;
		pcs.firePropertyChange("currentPlayer", old, currentPlayer);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
	
}
