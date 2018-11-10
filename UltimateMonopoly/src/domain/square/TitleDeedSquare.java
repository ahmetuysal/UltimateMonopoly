package domain.square;

import domain.Player;

public class TitleDeedSquare extends OwnableSquare {

	private int rentValue;
	private int[] rentWithHouses;
	private int rentWithHotel;
	private int rentWithSkyscrapers;
	private int numHouses;
	private int numHotels;
	private int numSkyscrapers;
	private TitleDeedSquareColor color;

	public TitleDeedSquare(String name, String description, int price, int rentValue, int rentOneHouse,
			int rentTwoHouses, int rentThreeHouses, int rentFourHouses, int rentHotel, int rentSkyscraper,
			TitleDeedSquareColor color) {
		super(name, description, price);
		this.rentValue = rentValue;
		this.rentWithHouses = new int[4];
		this.rentWithHouses[0] = rentOneHouse;
		this.rentWithHouses[1] = rentTwoHouses;
		this.rentWithHouses[2] = rentThreeHouses;
		this.rentWithHouses[3] = rentFourHouses;
		this.rentWithHotel = rentHotel;
		this.rentWithSkyscrapers = rentSkyscraper;
		this.numHouses = 0;
		this.numHotels = 0;
		this.numSkyscrapers = 0;
		this.color = color;
	}

	/**
	 * @return the numHouses
	 */
	public int getNumHouses() {
		return numHouses;
	}

	/**
	 * @return the numHotels
	 */
	public int getNumHotels() {
		return numHotels;
	}

	/**
	 * @return the numSkyscrapers
	 */
	public int getNumSkyscrapers() {
		return numSkyscrapers;
	}

	/**
	 * @return the color
	 */
	public TitleDeedSquareColor getColor() {
		return color;
	}

	/**
	 * @param numHouses
	 *            the numHouses to set
	 */
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	/**
	 * @param numHotels
	 *            the numHotels to set
	 */
	public void setNumHotels(int numHotels) {
		this.numHotels = numHotels;
	}

	/**
	 * @param numSkyscrapers
	 *            the numSkyscrapers to set
	 */
	public void setNumSkyscrapers(int numSkyscrapers) {
		this.numSkyscrapers = numSkyscrapers;
	}

	/**
	 * 
	 */
	@Override
	public void landOn(Player player) {
		if (this.isOwned()) {
			int rentAmount = this.calculateRent();
			player.payMoney(this.getOwner(), rentAmount);
		} else {
			// TODO: Prompt user to buy the property on the UI.
		}
	}
	
	
	
	// Private helper methods

	private int calculateRent() {
		if (!this.isOwned())
			return 0;

		if (this.numHouses != 0)
			return this.rentWithHouses[this.numHouses - 1];
		else if (this.numHotels != 0)
			return this.rentWithHotel;
		else if (this.numSkyscrapers != 0)
			return this.rentWithSkyscrapers;
		else {
			int numOwnedFromColor = this.getOwner().getNumTitleDeedsWithColor(this.color);
			if (numOwnedFromColor == this.color.numProperty())
				return 3 * rentValue;
			else
				return rentValue;
		}
	}

}
