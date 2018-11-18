package domain.die;

import java.io.Serializable;

public abstract class Die implements Serializable{

	protected int value;

	public void roll() {
		value = (int) (6 * Math.random());
	}

	public abstract DieValue getFaceValue();
}
