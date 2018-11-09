package domain;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;

public class Player {

	private String nickName;
	private int totalMoney;
	private boolean isReverseDirection;
	private boolean inJail;
	private int jailTime;
	private List<Card> cards;
	private Token token;

	/**
	 * @param nickName
	 *            Nick name of the player.
	 * @param totalMoney
	 *            Starting money of the player.
	 */
	public Player(String nickName, int totalMoney) {
		this.nickName = nickName;
		this.totalMoney = totalMoney;
		this.isReverseDirection = false;
		this.inJail = false;
		this.jailTime = 0;
		this.cards = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [nickName=" + nickName + "]";
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

}
