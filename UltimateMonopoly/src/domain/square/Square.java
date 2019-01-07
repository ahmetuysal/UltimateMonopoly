package domain.square;

import java.io.Serializable;

import domain.GameController;
import domain.Player;

public abstract class Square implements Serializable{

	protected String name;
	protected String description;
	protected Location location;
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public Square setLocation(Location location) {
		this.location = location;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Square(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * 
	 * @param player
	 *            Player who lands on this square.
	 */
	public void landOn(Player player) {
		GameController.getInstance().setCurrentLocationBuyable(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Square [name=" + name + ", description=" + description + "]";
	}

}
