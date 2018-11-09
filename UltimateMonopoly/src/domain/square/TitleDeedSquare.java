package domain.square;

import java.awt.Color;

import domain.Player;

public class TitleDeedSquare extends Square {
	private int price;
	private int rentValue;
	private Player owner;
	private int numHouses;
	private int numHotels;
	private int numSkyscrapers;
	private TitleDeedSquareColor color;
	private boolean isOwned;
	
	public TitleDeedSquare(String name, String description, int price, int rentValue, TitleDeedSquareColor color, String type){
		super(name, description, type);
		this.price = price;
		this.rentValue = rentValue;
		this.owner = null;
		this.numHouses = 0;
		this.numHotels = 0;
		this.numSkyscrapers = 0;
		this.color = color;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the rentValue
	 */
	public int getRentValue() {
		return rentValue;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
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
	 * @return the isOwned
	 */
	public boolean isOwned() {
		return isOwned;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		if(owner == null)
			isOwned = false;
		this.owner = owner;
	}

	/**
	 * @param numHouses the numHouses to set
	 */
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}

	/**
	 * @param numHotels the numHotels to set
	 */
	public void setNumHotels(int numHotels) {
		this.numHotels = numHotels;
	}

	/**
	 * @param numSkyscrapers the numSkyscrapers to set
	 */
	public void setNumSkyscrapers(int numSkyscrapers) {
		this.numSkyscrapers = numSkyscrapers;
	}
	
	
}
