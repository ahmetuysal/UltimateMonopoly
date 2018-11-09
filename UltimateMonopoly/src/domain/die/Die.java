package domain.die;

public abstract class Die {

	protected int value;

	public void roll() {
		value = (int) (6 * Math.random());
	}

	public abstract DieValue getFaceValue();
}
