package domain.communication.network;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import domain.die.Cup;

public class GameState implements Serializable {

	private List<Player> players = new ArrayList<Player>();
	private Cup cup;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;
	private int clientIndex = 0;// arbitrary
	private String content;
	private String type;
	
	public GameState(){
		currentPlayerIndex = 0;
		consecutiveDoubles = 0;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getClientIndex() {
		return clientIndex;
	}

	public void setClientIndex(int clientIndex) {
		this.clientIndex = clientIndex;
	}
	
	// For debugging purposes
	public String toString() {
		return cup.getFaceValues()[0].getValue() + " " + cup.getFaceValues()[1].getValue() + " " + cup.getFaceValues()[2].getValue();
	}
	
	
	
	
}