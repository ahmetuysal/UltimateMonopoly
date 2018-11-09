package domain.die;

public class RegularDie extends Die {

	private static final DieValue[] POSSIBLE_VALUES_REGULAR = {DieValue.ONE, DieValue.TWO, 
			DieValue.THREE,DieValue.FOUR, DieValue.FIVE, DieValue.SIX};
	
	public DieValue getFaceValue() {
		return POSSIBLE_VALUES_REGULAR[value];
	}
	
}
