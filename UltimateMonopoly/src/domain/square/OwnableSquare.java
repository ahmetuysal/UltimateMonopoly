package domain.square;

import domain.Player;

public abstract class OwnableSquare extends SquareFactory {
	
	private int price;
	private Player owner;
	private boolean isOwned;

	
	public OwnableSquare(String name, String description, int price) {
		super(name, description);
		this.price = price;
		this.owner = null;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
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

}
