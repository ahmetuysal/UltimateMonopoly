package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import domain.die.Cup;
import domain.die.DieValue;
import domain.square.OwnableSquare;
import domain.square.Square;
import domain.square.TitleDeedSquare;
import domain.util.Observable;
import domain.Player;
import domain.card.Card;
import domain.card.CardFactory;
import domain.card.ChanceCard;
import domain.card.CommunityChestCard;
import domain.card.RollThreeCard;
import domain.Board;

public class GameController extends Observable {

	private Board board;
	private Cup cup;
	private List<Player> players;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;
	private LinkedList<Card> chanceCardList;
	private LinkedList<Card> communityChestCardList;
	private LinkedList<Card> rollThreeCardList;
	private int poolMoney;
	
	// DieValues for updating UI (Using Observer Pattern)
	private DieValue die1Value; 
	private DieValue die2Value;
	private DieValue die3Value;
	
	private boolean withNetwork;
	private boolean playerSentToJailForDouble;
	private boolean currentLocationBuyable;

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
		initCards();
	}
	
	public void passTurn() {
		if (playerSentToJailForDouble || !cup.isDouble()) {
			playerSentToJailForDouble = false;
			consecutiveDoubles = 0;
			this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			setCurrentPlayer(currentPlayerIndex);
			publishPropertyEvent("isTurnFinished", false, true);
		}
	}
	
	public void buyProperty() {
		Square sq = board.getSquare(currentPlayer.getToken().getLocation());
		if (sq instanceof OwnableSquare && !((OwnableSquare) sq).isOwned()) {
			if(((OwnableSquare) sq).buyProperty(currentPlayer)) {
				currentPlayer.addProperty((OwnableSquare) sq);
			}
		}
		publishPropertyEvent("currentLocationBuyable", currentLocationBuyable, false);
	}
	
	public void setCurrentLocationBuyable(boolean isBuyable) {
		System.out.println("Is buyable: " + isBuyable);
		publishPropertyEvent("currentLocationBuyable", currentLocationBuyable, isBuyable);
		currentLocationBuyable = isBuyable;
	}
	
	public void promptDrawChanceCard() {
		publishPropertyEvent("drawChanceCard", false, true);
	}
	
	public void promptDrawCommunityChestCard() {
		publishPropertyEvent("drawCommunityChestCard", false, true);
	}
	
	public void promptDrawRollThreeCard() {
		publishPropertyEvent("drawRollThreeCard", false, true);
	}
	
	public void drawChanceCard() {
		Card card = chanceCardList.removeFirst();
		publishPropertyEvent("cardNameChance", null, card.getName());
		// assumed it will be used instanly for now
		// will change it for ownable cards
		card.useCard(currentPlayer, "");
		chanceCardList.addLast(card);
		publishPropertyEvent("drawChanceCard", true, false);
	}
	
	public void drawCommunityChestCard() {
		Card card = communityChestCardList.removeFirst();
		publishPropertyEvent("cardNameCommunityChest", null, card.getName());
		// assumed it will be used instanly for now
		// will change it for ownable cards
		card.useCard(currentPlayer, "");
		communityChestCardList.addLast(card);
		publishPropertyEvent("drawCommunityChestCard", true, false);
	}
	
	public void drawRollThreeCard() {
		Card card = rollThreeCardList.removeFirst();
		publishPropertyEvent("cardNameRollThree", null, card.getName());
		currentPlayer.addCard(card);
		rollThreeCardList.addLast(card);
		publishPropertyEvent("drawRollThreeCard", true, false);
	}
	
	public int getPoolMoney() {
		return poolMoney;
	}
	
	public void increasePoolMoney(int amount) {
		poolMoney += amount;
	}
	
	public boolean registerUser(String nickname, String tokenName) {
		if (Token.isTokenAvailable(tokenName)) {
			Player player = new Player(nickname);
			Token token = new Token(player, Board.getStartLocation(), tokenName);
			players.add(player);
			player.setToken(token);
			board.addToken(token);
			return true;
		}
		else {
			return false;
		}
	}

	private void initTokens() {
		Token.initializeAvailableTokens();
	}

	public void initTurnOrder() {
		initRollThreeCards();
		// TODO
		currentPlayerIndex = 0;
		currentPlayer = players.get(currentPlayerIndex);
	}
	
	public void initRollThreeCards() {
		for(int i=0;i<players.size();i++) {
			Card card = rollThreeCardList.removeFirst();
			players.get(i).addCard(card);
			rollThreeCardList.addLast(card);
		}
	}
	
	public void playTurn() {
		rollDice();
		if (currentPlayer.isInJail()) {
			if (cup.isDouble()) {
				currentPlayer.getOutOfJail();
			}
			currentPlayer.decreaseJailTime();
		}
		
		if (currentPlayer.isInJail()) {
			publishPropertyEvent("isTurnFinished", true, false);
			return;
		}
		else if (cup.isMrMonopoly()) {
			board.movePlayer(currentPlayer, cup.getTotal());
			// TODO check if all properties are owned.
			board.moveToNextUnownedProperty(currentPlayer);
		}
		else if (cup.isBusIcon()) {
			board.movePlayer(currentPlayer, cup.getTotal());
			board.moveToNextChanceOrCommunityChestSquare(currentPlayer);
		}
		else if (cup.isTriple()) {
			// TODO move user to wherever he wants 
			// do not move again
			publishPropertyEvent("isTurnFinished", true, false);
			return;
		}
		else if (cup.isDouble()) {
			consecutiveDoubles++;
			if (consecutiveDoubles == 3) {
				currentPlayer.goToJail();
				playerSentToJailForDouble = true;
				publishPropertyEvent("isTurnFinished", true, false);
				return;
			}
			else {
				board.movePlayer(currentPlayer, cup.getTotal());
				return;
			}
		}
		else {
			board.movePlayer(currentPlayer, cup.getTotal());
			publishPropertyEvent("isTurnFinished", true, false);
			return;
		}
		
		if (!cup.isDouble()) {
			publishPropertyEvent("isTurnFinished", true, false);
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

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	public Cup getCup() {
		return cup;
	}

	public void setCup(Cup cup) {
		this.cup = cup;
		DieValue[] newValues = cup.getFaceValues();
		publishPropertyEvent("die1", die1Value, newValues[0]);
		die1Value = newValues[0];
		publishPropertyEvent("die2", die2Value, newValues[1]);
		die2Value = newValues[1];
		publishPropertyEvent("die3", die3Value, newValues[2]);
		die3Value = newValues[2];
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

	public void rollThree() {
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

	private void initCards() {
		// We used LL because we will do lots of removeFirst & addLast
		chanceCardList = new LinkedList<Card>();
		communityChestCardList = new LinkedList<Card>();
		rollThreeCardList = new LinkedList<Card>();
		
//		chanceCardList.add(CardFactory.getCard("Advance to the Pay Corner"));
//		chanceCardList.add(CardFactory.getCard("Go To Jail!"));
//		chanceCardList.add(CardFactory.getCard("Advance to the Nearest Railroad"));
//		chanceCardList.add(CardFactory.getCard("Make General Repairs to all your properties."));
//		chanceCardList.add(CardFactory.getCard("Get Out of Jail Free!"));
		chanceCardList.add(CardFactory.getCard("Advance to the Saint Charles Place"));
		chanceCardList.add(CardFactory.getCard("Holiday Bonus!"));
//		chanceCardList.add(CardFactory.getCard("Just Say 'NO'!"));
//		chanceCardList.add(CardFactory.getCard("Buyer's Market!"));
//		chanceCardList.add(CardFactory.getCard("See You In Court!"));
//		chanceCardList.add(CardFactory.getCard("Foreclosed Property Sale!"));
//		chanceCardList.add(CardFactory.getCard("Get Rollin'"));
//		chanceCardList.add(CardFactory.getCard("Forward Thinker"));
//		chanceCardList.add(CardFactory.getCard("Hurricane makes landfall!"));
//		chanceCardList.add(CardFactory.getCard("Property Taxes"));
//		chanceCardList.add(CardFactory.getCard("Ride the Subway"));
//		chanceCardList.add(CardFactory.getCard("Social Media Fail!"));
//		chanceCardList.add(CardFactory.getCard("Pay Back!"));
//		chanceCardList.add(CardFactory.getCard("MARDI GRAS!"));
//		chanceCardList.add(CardFactory.getCard("GPS is not working"));
//		chanceCardList.add(CardFactory.getCard("Zero Dollars Down!"));
//		chanceCardList.add(CardFactory.getCard("Changing Lanes Below"));
//		chanceCardList.add(CardFactory.getCard("Changing Lanes Above"));
		
//		communityChestCardList.add(CardFactory.getCard("Happy Birthday!"));
//		communityChestCardList.add(CardFactory.getCard("Game Night!"));
		communityChestCardList.add(CardFactory.getCard("A Moving Experience"));
//		communityChestCardList.add(CardFactory.getCard("HOUSE CONDEMNED"));
//		communityChestCardList.add(CardFactory.getCard("Elected District Attorney"));
//		communityChestCardList.add(CardFactory.getCard("Deal Buster"));
//		communityChestCardList.add(CardFactory.getCard("Be Kind, Rewind"));
		communityChestCardList.add(CardFactory.getCard("Pay Hospital Bills"));
//		communityChestCardList.add(CardFactory.getCard("Tornado Hits!"));
//		communityChestCardList.add(CardFactory.getCard("Share in their Good Fortune"));
		communityChestCardList.add(CardFactory.getCard("The Insider's Edge"));
		
		rollThreeCardList.add(CardFactory.getCard("123"));
		rollThreeCardList.add(CardFactory.getCard("124"));
		rollThreeCardList.add(CardFactory.getCard("125"));
		rollThreeCardList.add(CardFactory.getCard("126"));
		rollThreeCardList.add(CardFactory.getCard("134"));
		rollThreeCardList.add(CardFactory.getCard("135"));
		rollThreeCardList.add(CardFactory.getCard("136"));
		rollThreeCardList.add(CardFactory.getCard("145"));
		rollThreeCardList.add(CardFactory.getCard("146"));
		rollThreeCardList.add(CardFactory.getCard("156"));
		rollThreeCardList.add(CardFactory.getCard("234"));
		rollThreeCardList.add(CardFactory.getCard("245"));
		rollThreeCardList.add(CardFactory.getCard("246"));
		rollThreeCardList.add(CardFactory.getCard("256"));
		rollThreeCardList.add(CardFactory.getCard("345"));
		rollThreeCardList.add(CardFactory.getCard("346"));
		rollThreeCardList.add(CardFactory.getCard("356"));
		rollThreeCardList.add(CardFactory.getCard("456"));
		rollThreeCardList.add(CardFactory.getCard("246"));
		rollThreeCardList.add(CardFactory.getCard("256"));
		rollThreeCardList.add(CardFactory.getCard("345"));
		rollThreeCardList.add(CardFactory.getCard("346"));
		rollThreeCardList.add(CardFactory.getCard("356"));
		rollThreeCardList.add(CardFactory.getCard("456"));
		
		Collections.shuffle(chanceCardList);
		Collections.shuffle(communityChestCardList);
		Collections.shuffle(rollThreeCardList);
	}

	public void playCard() {
		// TODO Auto-generated method stub
		
	}
	
}
