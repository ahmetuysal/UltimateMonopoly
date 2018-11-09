package domain.die;

public enum DieValue {
	EMPTY(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), BUSICON(7), MRMONOPOLY(8);

	private final int value;

	DieValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
