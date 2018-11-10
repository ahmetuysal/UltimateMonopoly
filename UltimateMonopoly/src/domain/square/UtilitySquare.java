package domain.square;

import domain.Player;

public class UtilitySquare extends OwnableSquare {
	
	private UtilitySquareType type;

	public UtilitySquare(String name, String description, int price, UtilitySquareType type) {
		super(name, description, price);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public UtilitySquareType getType() {
		return type;
	}

	@Override
	public void landOn(Player player) {
		// TODO Auto-generated method stub
		
	}


}
