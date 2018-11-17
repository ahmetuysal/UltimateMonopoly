package domain;

import java.util.ArrayList;
import java.util.List;

import domain.die.Cup;
import domain.die.DieValue;
import domain.square.Location;
import domain.square.Square;
import domain.util.Observable;
import domain.Player;
import domain.Board;

public class GameController extends Observable {

	private Board board;
	private Cup cup;
	private List<Player> players;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;
	
	// DieValues for updating UI (Using Observer Pattern)
	private DieValue die1Value; 
	private DieValue die2Value;
	private DieValue die3Value;
	
	private boolean withNetwork;

	private static GameController instance;

	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private GameController() {
		board = new Board();
		cup = new Cup();
		players = new ArrayList<>();
		initTokens();
		initBoard();
	}
	
	public boolean registerUser(String nickname, String tokenName) {
		if (Token.isTokenAvailable(tokenName)) {
			Player player = new Player(nickname);
			Token token = new Token(player, Board.START_LOCATION, tokenName);
			player.setToken(token);
			board.addToken(token);
			return true;
		}
		else {
			return false;
		}
	}

	private void initBoard() {
		board.addSquares();

	}

	private void initCards() {
		// TODO
	}
	
	private void initTokens() {
		Token.initializeAvailableTokens();
	}

	public void initTurnOrder() {
		// TODO
		currentPlayer = players.get(0);
	}
	
	public void playTurn() {
		// TODO: fix this
		rollDice();
		if (currentPlayer.isInJail()) {
			if (cup.isDouble()) {
				currentPlayer.getOutOfJail();
			}
			currentPlayer.decreaseJailTime();
		}
		// We need to call isTriple first
		// (isDouble return true even if triple)
		if (currentPlayer.isInJail()) {
			consecutiveDoubles = 0;
			this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			setCurrentPlayer(currentPlayerIndex);
		}
		else if (cup.isMrMonopoly()) {
			board.movePlayer(currentPlayer, cup.getTotal());
			// TODO go to first unowned square
			consecutiveDoubles = 0;
			this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			setCurrentPlayer(currentPlayerIndex);
		}
		else if (cup.isBusIcon()) {
			board.movePlayer(currentPlayer, cup.getTotal());
			// TODO go to first chance or community square
			consecutiveDoubles = 0;
			this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			setCurrentPlayer(currentPlayerIndex);
		}
		else if (cup.isTriple()) {
			// TODO move user to wherever he wants 
			// do not move again
			consecutiveDoubles = 0;
			this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			setCurrentPlayer(currentPlayerIndex);
		}
		else if (cup.isDouble()) {
			consecutiveDoubles++;
			if (consecutiveDoubles == 3) {
				currentPlayer.goToJail();
				consecutiveDoubles = 0;
				this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
				setCurrentPlayer(currentPlayerIndex);
			}
			else {
				board.movePlayer(currentPlayer, cup.getTotal());
			}
		}
		else {
			consecutiveDoubles = 0;
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

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	public Cup getCup() {
		return cup;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void quitGame() {
		System.exit(0);
	}

	public void rollDice() {
		if (currentPlayer.isInJail()) {
			cup.rollTwoRegularDices();
		} else {
			cup.rollDices();
		}

		DieValue[] newValues = cup.getFaceValues();
		publishPropertyEvent("die1", die1Value, newValues[0]);
		die1Value = newValues[0];
		publishPropertyEvent("die2", die2Value, newValues[1]);
		die2Value = newValues[1];
		publishPropertyEvent("die3", die3Value, newValues[2]);
		die3Value = newValues[2];
	}

	public void rollTriple() {
		cup.rollThreeRegularDices();
		
		DieValue[] newValues = cup.getFaceValues();
		publishPropertyEvent("die1", die1Value, newValues[0]);
		die1Value = newValues[0];
		publishPropertyEvent("die2", die2Value, newValues[1]);
		die2Value = newValues[1];
		publishPropertyEvent("die3", die3Value, newValues[2]);
		die3Value = newValues[2];
	}

	public List<Player> getPlayerList() {
		return players;
	}
	
	public void buyTitleDeed() {
		board.buyTitleDeed(currentPlayer);
	}
	
	public void buildHouse(int houseNum) {
		board.buildHouse(currentPlayer, houseNum);
	}
	
	public void buildHotel() {
		board.buildHotel(currentPlayer);
	}

	public void buildSkyscraper() {
		board.buildSkyscraper(currentPlayer);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}

	public int getConsecutiveDoubles() {
		return consecutiveDoubles;
	}

	public void setConsecutiveDoubles(int consecutiveDoubles) {
		this.consecutiveDoubles = consecutiveDoubles;
	}

	public boolean isWithNetwork() {
		return withNetwork;
	}

	public void setWithNetwork(boolean withNetwork) {
		this.withNetwork = withNetwork;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	
}
