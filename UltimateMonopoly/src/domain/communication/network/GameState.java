package domain.communication.network;

import java.util.ArrayList;
import java.util.List;

import domain.Player;
import domain.die.Cup;

public class GameState {

	private List<Player> players = new ArrayList<Player>();
	private Cup cup;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;
	
	public GameState(){
		currentPlayerIndex = 0;
		consecutiveDoubles = 0;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Cup getCup() {
		return cup;
	}

	public void setCup(Cup cup) {
		this.cup = cup;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getConsecutiveDoubles() {
		return consecutiveDoubles;
	}

	public void setConsecutiveDoubles(int consecutiveDoubles) {
		this.consecutiveDoubles = consecutiveDoubles;
	}
	
	
}