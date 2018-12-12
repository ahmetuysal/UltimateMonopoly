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
	
	
	public boolean buyHouse() {
		if (!this.isOwned()) {
			System.out.println("Can't build a house on an unowned property!");
			return false;
		}
		if (this.owner.getTotalMoney() < this.color.housePriceProperty()) {
			System.out.println("You don't have enough money to build a house!");
			return false;
		}
		if (this.numHouses == 4 || this.numHotels > 0 || this.numSkyscrapers > 0) {
			System.out.println("You can't build more than 4 houses on the same property!");
			return false;
		}
		
		this.owner.decreaseMoney(color.housePriceProperty());
		this.numHouses++;
		return true;
	}
	
	public boolean buyHotel() {
		if (!this.isOwned()) {
			System.out.println("Can't build a house on an unowned property!");
			return false;
		}
		if (this.numHouses != 4) {
			System.out.println("You can't build an hotel without building 4 houses!");
			return false;
		}
		if (this.owner.getTotalMoney() < this.color.hotelPriceProperty()) {
			System.out.println("You don't have enough money to build a hotel!");
			return false;
		}
		if (this.numHotels == 1 || this.numSkyscrapers > 0) {
			System.out.println("You can't build more than one hotel on the same property!");
			return false;
		}
		
		this.owner.decreaseMoney(color.hotelPriceProperty());
		this.numHouses = 0;
		this.numHotels++;
		return true;
	}
	
	public boolean buySkyScraper() {
		if (!this.isOwned()) {
			System.out.println("Can't build a house on an unowned property!");
			return false;
		}
		if (this.owner.getTotalMoney() < this.color.skyScraperPriceProperty()) {
			System.out.println("You don't have enough money to build a skyscraper!");
			return false;
		}
		if (this.numHotels!= 1) {
			System.out.println("You can't build an skyscraper without building a hotel!");
			return false;
		}
		if (this.numSkyscrapers == 1) {
			System.out.println("You have already built a skyscraper. You can't build more!");
			return false;
		}
		
		this.owner.decreaseMoney(this.color.skyScraperPriceProperty());
		this.numHotels = 0;
		this.numSkyscrapers++;
		return true;
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
