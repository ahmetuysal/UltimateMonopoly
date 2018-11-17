package domain;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;
import domain.square.OwnableSquare;
import domain.square.TitleDeedSquare;
import domain.square.TitleDeedSquareColor;

public class Player {

	private String nickName;
	private int totalMoney;
	private boolean isReverseDirection;
	private boolean inJail;
	private int jailTime;
	private List<Card> cards;
	private List<OwnableSquare> properties;
	private Token token;

	private static final int START_MONEY = 3200;
	
	/**
	 * @param nickName
	 *            Nick name of the player.
	 * @param totalMoney
	 *            Starting money of the player.
	 */
	public Player(String nickName) {
		this.nickName = nickName;
		this.totalMoney = START_MONEY;
		this.isReverseDirection = false;
		this.inJail = false;
		this.jailTime = 0;
		this.cards = new ArrayList<>();
		this.properties = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nickName + " " + totalMoney + " " + isReverseDirection + " " + inJail + " " + jailTime + " "
				+ cardList(); // token will be added later
	}

	public String cardList() {
		String ownedCards = "";
		for (Card c : cards) {
			ownedCards += c.getName() + " ";
		}
		return ownedCards;
	}

	/**
	 * @return The nick name of the player.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            The nick name of the player to set.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return The current money amount of the player.
	 */
	public int getTotalMoney() {
		return totalMoney;
	}

	/**
	 * @param money
	 *            The amount to be added to player's total money.
	 * 
	 */
	public void increaseMoney(int money) {
		this.totalMoney += totalMoney;
	}

	/**
	 * @param money
	 *            The amount to decrease from player's total money.
	 * @return <tt>true</tt> if player is capable of paying and has paid to money,
	 *         <tt>false</tt> otherwise.
	 */
	public boolean decreaseMoney(int money) {
		if (this.totalMoney < money) {
			return false;
		}
		this.totalMoney -= money;
		return true;
	}

	/**
	 * 
	 * @param player
	 *            The player who will get the money.
	 * @param money
	 *            The amount to pay.
	 */
	public void payMoney(Player player, int money) {
		if (this.getTotalMoney() < money) {
			this.goBankrupt();
			return;
		}
		this.decreaseMoney(money);
		player.increaseMoney(money);
	}

	/**
	 * @return <tt>true</tt> if player is moving in reverse direction,
	 *         <tt>false</tt> otherwise.
	 */
	public boolean isReverseDirection() {
		return isReverseDirection;
	}

	/**
	 * @param isReverseDirection
	 *            Whether the player is moving in reverse direction or not.
	 */
	public void setReverseDirection(boolean isReverseDirection) {
		this.isReverseDirection = isReverseDirection;
	}

	/**
	 * @return <tt>true</tt> if player is in jail, <tt>false</tt> otherwise.
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 *
	 */
	public void goToJail() {
		this.inJail = true;
		this.jailTime = 3;
		this.token.setLocation(GameController.getInstance().getBoard().getSquareLocationFromName("Jail"));
	}

	/**
	 * Called when player uses get out of jail card or rolls double in jail.
	 */
	public void getOutOfJail() {
		this.jailTime = 0;
		this.inJail = false;
	}

	/**
	 * @return The list of Cards player has.
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * @param card
	 *            The card to be added to player's list of cards.
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 * @param card
	 *            The card to be removed from player's list of cards.
	 * @return <tt>true</tt> if card is removed from player's list of cards,
	 *         <tt>false</tt> if card was not in the list.
	 */
	public boolean removeCard(Card card) {
		return this.cards.remove(card);
	}
	
	public void addProperty(TitleDeedSquare prop){
		this.properties.add(prop);
	}
	
	public boolean removeProperty(TitleDeedSquare prop){
		return this.properties.remove(prop);
	}

	/**
	 * @return the jailTime
	 */
	public int getJailTime() {
		return jailTime;
	}

	/**
	 * 
	 */
	public void decreaseJailTime() {
		if (this.jailTime > 0) {
			this.jailTime--;
			this.inJail = this.jailTime != 0;
		}
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token t) {
		this.token = t;
	}

	public boolean goBankrupt() {
		// TODO implement this
		return false;
	}

	public int getNumTitleDeedsWithColor(TitleDeedSquareColor color) {
		int result = 0;
		for (OwnableSquare ownable : this.properties) {
			if (ownable instanceof TitleDeedSquare) {
				if (((TitleDeedSquare) ownable).getColor() == color)
					result++;
			}
		}
		return result;
	}
	
	public boolean houseCheckForHotelBuilding(TitleDeedSquareColor color) {
		boolean hotelBuild = false;;
		for (OwnableSquare ownable : this.properties) {
			if (ownable instanceof TitleDeedSquare) {
				if (((TitleDeedSquare) ownable).getColor() == color) {
					if(((TitleDeedSquare) ownable).getNumHouses() == 4)
						hotelBuild = true;
					else {
						hotelBuild = false;
						break;
					}
				}
					
			}
		}
		return hotelBuild;
	}
	
	public boolean hotelCheckForSkyscraperBuilding(TitleDeedSquareColor color) {
		boolean skyscraperBuild = false;;
		for (OwnableSquare ownable : this.properties) {
			if (ownable instanceof TitleDeedSquare) {
				if (((TitleDeedSquare) ownable).getColor() == color) {
					if(((TitleDeedSquare) ownable).getNumHouses() == 1)
						skyscraperBuild = true;
					else {
						skyscraperBuild = false;
						break;
					}
				}
					
			}
		}
		return skyscraperBuild;
	}
	

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
		
	}
	
	public List<OwnableSquare> getProperties() {
		return properties;
	}
	
}
