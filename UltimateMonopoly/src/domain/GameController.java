package domain;

import java.util.ArrayList;
import java.util.List;

import domain.die.Cup;
import domain.square.Square;
import domain.square.TitleDeedSquare;
import domain.square.TitleDeedSquareColor;
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
	}
	
	private boolean registerUser(String nickname, String tokenName) {
		if (Token.isTokenAvailable(tokenName)) {
			Player player = new Player(nickname);
			Token token = new Token(player, Board.START_LOCATION, tokenName);
			player.setToken(token);
			return true;
		}
		else {
			return false;
		}
	}

	private void initBoard() {
		board.addSquares();

	}

	private void initPlayers() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).getNickName();
			players.get(i).setTotalMoney(3200);
		}
	}
	
	private void initCards() {
		// TODO
	}
	
	private void initTokens() {
		Token.initializeAvailableTokens();
	}

	private void initTurnOrder() {
		// TODO
	}
	
	public void playTurn() {
		// TODO: fix this
		rollDice();
		if (currentPlayer.isInJail()) {
			if (cup.isDouble()) {
				currentPlayer.getOutOfJail();
			}
		}
		if (cup.isDouble()) {
			consecutiveDoubles++;
			if (consecutiveDoubles == 3) {
				currentPlayer.goToJail();
			}
		} else {
			consecutiveDoubles = 0;
		}
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
	}

	public void rollTriple() {
		cup.rollThreeRegularDices();
	}

	public List<Player> getPlayerList() {
		return players;
	}
	
	public void buyTitleDeed(Player currentPlayer) {
		board.buyTitleDeed(currentPlayer);
	}
	
	public void buildHouse(Player currentPlayer, int houseNum) {
		board.buildHouse(currentPlayer, houseNum);
	}
	
	public void buildHotel(Player currentPlayer) {
		board.buildHotel(currentPlayer);
	}

	public void buildSkyscraper(Player currentPlayer) {
		board.buildSkyscraper(currentPlayer);
	}
}
