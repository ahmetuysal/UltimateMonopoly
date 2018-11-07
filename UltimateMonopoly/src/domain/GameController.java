package domain;

import java.util.ArrayList;
import java.util.List;

import domain.die.Cup;
import domain.util.Observable;

public class GameController extends Observable {

	private Board board;
	private Cup cup;
	private List<Player> players;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;


	public GameController() {
		board = new Board();
		cup = new Cup();
		players = new ArrayList<>();
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
		publishPropertyEvent("controller.currentPlayer", old, currentPlayer);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
	
}
