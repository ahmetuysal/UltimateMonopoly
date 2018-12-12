package domain.square;

import domain.Player;

public abstract class OwnableSquare extends Square {
	
	protected int price;
	protected Player owner;
	protected boolean isOwned;

	
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
		isOwned = owner != null;
		this.owner = owner;
		
	}
	
	public boolean buyProperty(Player owner) {
		if(isOwned) {
			System.out.println("Property " + this.getName() + " is already owned");
			return false;
		}
		
		if(owner.getTotalMoney() < this.price) {
			System.out.println("Player " + owner.getNickName() + " does not have enough money");
			return false;
		}
		else {
			owner.decreaseMoney(this.price);
			this.setOwner(owner);
			return true;
		}
		
	}

}
