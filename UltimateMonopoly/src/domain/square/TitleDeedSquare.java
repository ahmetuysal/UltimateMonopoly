package domain.square;

import java.util.List;

import domain.Player;

/**
 * Represents the TitleDeedSquare concept on Ultimate Monopoly Game.
 * 
 * @overview Responsible for calculating rent, buying buildings and handling
 *           rent.
 * 
 * @author Team Pennybags
 */
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
	 * Performs required actions when player lands on <b><tt>this</tt></b>.
	 * 
	 * @requires nothing
	 * @modifies owner, playerLanded, GameController
	 * @effects If <b><tt>this</tt></b> has an owner and the landed player is not
	 *          the owner, playerLanded pays rent to the owner. Updates the
	 *          GameController's field indicating current square's buyability
	 *          according to <b><tt>this</tt></b>.
	 */
	@Override
	public void landOn(Player player) {
		super.landOn(player);
		if (this.isOwned()) {
			if (!this.owner.equals(player)) {
				int rentAmount = this.calculateRent();
				player.payMoney(this.getOwner(), rentAmount);
			}
		}
	}

	/**
	 * Increases the number of houses of <b><tt>this</tt></b> if
	 * <b><tt>this</tt></b> and owner satisfies required conditions.
	 * 
	 * @requires <b><tt>this</tt></b> has an owner.
	 * @modifies <b><tt>this</tt></b>, owner
	 * @effects If owner has enough money and this satisfies the conditions of
	 *          buying a house (owner has majority ownership, this does not have a
	 *          hotel or skyscraper, has houses less than 4), a house is built on
	 *          this property and number of houses is increased. Player's money is
	 *          decreased to pay the price of the house.
	 * 
	 * @return <tt>true</tt> if a house is bought, <tt>false</tt> otherwise.
	 */
	public boolean buyHouse() {
		if (!this.isOwned()) {
			System.out.println("Can't build a house on an unowned property!");
			return false;
		}
		if (this.owner.getTotalMoney() < this.color.housePriceProperty()) {
			System.out.println("You don't have enough money to build a house!");
			return false;
		}
		if (!this.ownerHasMajorityOwnership()) {
			System.out.println("You need to have 'Majority Ownership' to buy a hotel!");
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

	/**
	 * Increases the number of hotels of <b><tt>this</tt></b> if
	 * <b><tt>this</tt></b> and owner satisfies required conditions.
	 * 
	 * @requires <b><tt>this</tt></b> has an owner.
	 * @modifies <b><tt>this</tt></b>, owner
	 * @effects If owner has enough money and this satisfies the conditions of
	 *          buying a hotel (owner has majority ownership, has 4 houses, does not
	 *          have a hotel or skyscraper), a hotel is built on this property and
	 *          number of houses is set to zero. Player's money is decreased to pay
	 *          the price of the hotel.
	 * 
	 * @return <tt>true</tt> if a hotel is bought, <tt>false</tt> otherwise.
	 */
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
		if (!this.ownerHasMajorityOwnership()) {
			System.out.println("You need to have 'Majority Ownership' to buy a hotel!");
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
		if (this.numHotels != 1) {
			System.out.println("You can't build an skyscraper without building a hotel!");
			return false;
		}
		if (this.ownerHasMonopoly()) {
			List<TitleDeedSquare> ownerPropertiesWithSameColor = owner.getTitleDeedsWithColor(this.color);
			for (TitleDeedSquare property : ownerPropertiesWithSameColor) {
				if (property.getNumHotels() == 0 && property.getNumSkyscrapers() == 0) {
					System.out.println(
							"You need to have a monopoly and hotels/skyscrapers in all property to buy a skyscraper!");
					return false;
				}
			}

		} else {
			System.out.println("You need to have a monopoly to buy a skyscraper!");
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
			if (ownerHasMonopoly())
				return 3 * rentValue;
			else if (ownerHasMajorityOwnership())
				return 2 * rentValue;
			else
				return rentValue;
		}
	}

	private boolean ownerHasMajorityOwnership() {
		if (!this.isOwned)
			return false;
		int numOwnedFromColor = this.getOwner().getNumTitleDeedsWithColor(this.color);
		if (this.color.numProperty() == 2) {
			return numOwnedFromColor == 2;
		}
		return numOwnedFromColor >= this.color.numProperty() - 1;
	}

	private boolean ownerHasMonopoly() {
		if (!this.isOwned)
			return false;
		int numOwnedFromColor = this.getOwner().getNumTitleDeedsWithColor(this.color);
		return numOwnedFromColor == this.color.numProperty();
	}

	@Override
	public boolean repOK() {
		if (!super.repOK())
			return false;
		if (rentValue < 0)
			return false;
		for (int rentWithHouse : this.rentWithHouses)
			if (rentWithHouse < 0)
				return false;
		if (rentWithHotel < 0)
			return false;
		if (rentWithSkyscrapers < 0)
			return false;
		if (numHouses < 0 || numHouses > 4)
			return false;
		if (numHotels < 0 || numHotels > 1)
			return false;
		if (numSkyscrapers < 0 || numSkyscrapers > 1)
			return false;
		return true;
	}

}
