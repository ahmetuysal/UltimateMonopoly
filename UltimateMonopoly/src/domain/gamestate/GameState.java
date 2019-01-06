package domain.gamestate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import domain.Board;
import domain.Player;
import domain.card.Card;
import domain.card.OwnableCard;
import domain.die.Cup;
import domain.die.DieValue;
import domain.square.OwnableSquare;
import domain.square.Square;

public class GameState implements Serializable {

	private Cup cup;
	private List<Player> players;
	private int currentPlayerIndex;
	private Player currentPlayer;
	private int consecutiveDoubles;
	private LinkedList<Card> chanceCardList;
	private LinkedList<Card> communityChestCardList;
	private LinkedList<OwnableCard> rollThreeCardList;
	private int poolMoney;

	private DieValue die1Value;
	private DieValue die2Value;
	private DieValue die3Value;

	private boolean isPaused;
	private boolean withNetwork;
	private boolean playerSentToJailForDouble;
	private boolean currentLocationBuyable;
	
	private int clientIndex = 0;// arbitrary
	private String content;
	private String type;

	/**
	 * @return the chanceCardList
	 */
	public LinkedList<Card> getChanceCardList() {
		return chanceCardList;
	}

	/**
	 * @param chanceCardList the chanceCardList to set
	 */
	public void setChanceCardList(LinkedList<Card> chanceCardList) {
		this.chanceCardList = chanceCardList;
	}

	/**
	 * @return the communityChestCardList
	 */
	public LinkedList<Card> getCommunityChestCardList() {
		return communityChestCardList;
	}

	/**
	 * @param communityChestCardList the communityChestCardList to set
	 */
	public void setCommunityChestCardList(LinkedList<Card> communityChestCardList) {
		this.communityChestCardList = communityChestCardList;
	}

	/**
	 * @return the rollThreeCardList
	 */
	public LinkedList<OwnableCard> getRollThreeCardList() {
		return rollThreeCardList;
	}

	/**
	 * @param rollThreeCardList the rollThreeCardList to set
	 */
	public void setRollThreeCardList(LinkedList<OwnableCard> rollThreeCardList) {
		this.rollThreeCardList = rollThreeCardList;
	}

	/**
	 * @return the poolMoney
	 */
	public int getPoolMoney() {
		return poolMoney;
	}

	/**
	 * @param poolMoney the poolMoney to set
	 */
	public void setPoolMoney(int poolMoney) {
		this.poolMoney = poolMoney;
	}

	/**
	 * @return the die1Value
	 */
	public DieValue getDie1Value() {
		return die1Value;
	}

	/**
	 * @param die1Value the die1Value to set
	 */
	public void setDie1Value(DieValue die1Value) {
		this.die1Value = die1Value;
	}

	/**
	 * @return the die2Value
	 */
	public DieValue getDie2Value() {
		return die2Value;
	}

	/**
	 * @param die2Value the die2Value to set
	 */
	public void setDie2Value(DieValue die2Value) {
		this.die2Value = die2Value;
	}

	/**
	 * @return the die3Value
	 */
	public DieValue getDie3Value() {
		return die3Value;
	}

	/**
	 * @param die3Value the die3Value to set
	 */
	public void setDie3Value(DieValue die3Value) {
		this.die3Value = die3Value;
	}

	/**
	 * @return the withNetwork
	 */
	public boolean isWithNetwork() {
		return withNetwork;
	}

	/**
	 * @param withNetwork the withNetwork to set
	 */
	public void setWithNetwork(boolean withNetwork) {
		this.withNetwork = withNetwork;
	}

	/**
	 * @return the playerSentToJailForDouble
	 */
	public boolean isPlayerSentToJailForDouble() {
		return playerSentToJailForDouble;
	}

	/**
	 * @param playerSentToJailForDouble the playerSentToJailForDouble to set
	 */
	public void setPlayerSentToJailForDouble(boolean playerSentToJailForDouble) {
		this.playerSentToJailForDouble = playerSentToJailForDouble;
	}

	/**
	 * @return the currentLocationBuyable
	 */
	public boolean isCurrentLocationBuyable() {
		return currentLocationBuyable;
	}

	/**
	 * @param currentLocationBuyable the currentLocationBuyable to set
	 */
	public void setCurrentLocationBuyable(boolean currentLocationBuyable) {
		this.currentLocationBuyable = currentLocationBuyable;
	}

	public GameState() {
		currentPlayerIndex = 0;
		consecutiveDoubles = 0;
		players = new ArrayList<>();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameState [cup=" + cup + ", players=" + players + ", currentPlayerIndex="
				+ currentPlayerIndex + ", currentPlayer=" + currentPlayer + ", consecutiveDoubles=" + consecutiveDoubles
				+ ", chanceCardList=" + chanceCardList + ", communityChestCardList=" + communityChestCardList
				+ ", rollThreeCardList=" + rollThreeCardList + ", poolMoney=" + poolMoney + ", die1Value=" + die1Value
				+ ", die2Value=" + die2Value + ", die3Value=" + die3Value + ", withNetwork=" + withNetwork
				+ ", playerSentToJailForDouble=" + playerSentToJailForDouble + ", currentLocationBuyable="
				+ currentLocationBuyable + ", clientIndex=" + clientIndex + ", content=" + content + ", type=" + type
				+ "]";
	}

	/**
	 * @return the isPaused
	 */
	public boolean isPaused() {
		return isPaused;
	}

	/**
	 * @param isPaused the isPaused to set
	 */
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public boolean repOK() {
		if(cup == null)
			return false;
		if(consecutiveDoubles > 3)
			return false;
		if(players == null || players.size() < 2)
			return false;
		if(chanceCardList == null || chanceCardList.size() != 2)
			return false;
		if(communityChestCardList == null || communityChestCardList.size() != 3)
			return false;
		if(rollThreeCardList == null || rollThreeCardList.size() != 24)
			return false;
		if(poolMoney < 0)
			return false;
		return true;
		
	}
}