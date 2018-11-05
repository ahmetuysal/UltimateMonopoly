package domain.die;

public class RegularDie extends Die {

	private int value;

	@Override
	public void roll() {
		value =(int) (6 * Math.random()) + 1 ;
	}
	
	public int getDieValue() {
		return value;
	}
	
}
