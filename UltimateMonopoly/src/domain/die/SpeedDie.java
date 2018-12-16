package domain.die;

public class SpeedDie extends Die {

	private static final DieValue[] POSSIBLE_VALUES_SPEED = { DieValue.ONE, DieValue.TWO, DieValue.THREE,
			DieValue.BUSICON, DieValue.MRMONOPOLY, DieValue.MRMONOPOLY, DieValue.EMPTY };

	public DieValue getFaceValue(){
		return POSSIBLE_VALUES_SPEED[value];
	}

	void setFaceValueEmpty() {
		this.value = 6; // Value for empty
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpeedDie [value=" + value + "]";
	}
	
	
}
