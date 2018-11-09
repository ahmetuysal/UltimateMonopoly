package domain.square;

public abstract class UtilitySquare extends Square {
	
	private UtilitySquareType type;

	public UtilitySquare(String name, String description, UtilitySquareType type) {
		super(name, description);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the type
	 */
	public UtilitySquareType getType() {
		return type;
	}


}
