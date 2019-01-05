package domain.square;

import domain.Player;

public class UtilitySquare extends OwnableSquare {

	private UtilitySquareType utilityType;

	public UtilitySquare(String name, String description, int price, UtilitySquareType utilityType) {
		super(name, description, price);
		this.utilityType = utilityType;
	}

	/**
	 * @return the type
	 */
	public UtilitySquareType getType() {
		return utilityType;
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic	}
	}
	


}
