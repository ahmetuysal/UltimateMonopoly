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
		// TODO
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
	
	public void buyTitleDeed() {
		Square currentSquare = board.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			if(!((TitleDeedSquare) currentSquare).isOwned()) {
				currentPlayer.addProperty((TitleDeedSquare) currentSquare);
				currentPlayer.decreaseMoney(((TitleDeedSquare) currentSquare).getPrice());
				((TitleDeedSquare) currentSquare).setOwner(currentPlayer);
				//TODO: ask for any extra implementation is needed??
			}
		}
	}
	
	public void buildHouse(int houseNum) {
		Square currentSquare = board.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			if(houseNum > -1 && (!(houseNum + ((TitleDeedSquare) currentSquare).getNumHouses() < 1 || ((TitleDeedSquare) currentSquare).getNumHouses() + houseNum > 4))) {
				TitleDeedSquareColor color = ((TitleDeedSquare) currentSquare).getColor();
				int numProperty = color.numProperty(); 
				if(numProperty > 2 && currentPlayer.equals(((TitleDeedSquare) currentSquare).getOwner())) {
					if(numProperty == ((TitleDeedSquare) currentSquare).getOwner().getNumTitleDeedsWithColor(color)) {
						int housePrice = color.homePriceProperty();
						if(currentPlayer.getTotalMoney() > houseNum*housePrice) {
							currentPlayer.decreaseMoney(houseNum*housePrice);
							((TitleDeedSquare) currentSquare).setNumHouses(houseNum);
						}
					}
				}
			}
		}
	}
	
	public void buildHotel() {
		Square currentSquare = board.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			TitleDeedSquareColor color = ((TitleDeedSquare) currentSquare).getColor();
			int numProperty = color.numProperty(); 
			if(numProperty > 2 && currentPlayer.equals(((TitleDeedSquare) currentSquare).getOwner())) {
				if(numProperty == ((TitleDeedSquare) currentSquare).getOwner().getNumTitleDeedsWithColor(color)) {
					
					//TODO: condition for house check! //if() {
					
						int hotelPrice = color.hotelPriceProperty();
						if(currentPlayer.getTotalMoney() > hotelPrice) {
							currentPlayer.decreaseMoney(hotelPrice);
							((TitleDeedSquare) currentSquare).setNumHotels(1);
							((TitleDeedSquare) currentSquare).setNumHouses(0);
						}
					//}	
				}
			}
		}
	}

	public void buildSkyscraper() {
		Square currentSquare = board.getSquare(currentPlayer.getToken().getLocation());
		if(currentSquare instanceof TitleDeedSquare) {
			TitleDeedSquareColor color = ((TitleDeedSquare) currentSquare).getColor();
			int numProperty = color.numProperty(); 
			if(numProperty > 2 && currentPlayer.equals(((TitleDeedSquare) currentSquare).getOwner())) {
				if(numProperty == ((TitleDeedSquare) currentSquare).getOwner().getNumTitleDeedsWithColor(color)) {
					
					//TODO: hotel check for every square in that color group!
					
					int skyScraperPrice = color.skyScraperPriceProperty();
					if(currentPlayer.getTotalMoney() > skyScraperPrice) {
						currentPlayer.decreaseMoney(skyScraperPrice);
						((TitleDeedSquare) currentSquare).setNumSkyscrapers(1);
						((TitleDeedSquare) currentSquare).setNumHotels(0);
					}
				}
			}
		}
	}



}
