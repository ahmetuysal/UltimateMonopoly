package domain.card;

import domain.Player;

public abstract class OwnableCard extends Card {
	
	private Player owner;
	private boolean isOwned;

	public OwnableCard(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
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
	
}
