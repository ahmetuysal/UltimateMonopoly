package domain.die;

public class Cup {
	
	private RegularDie die1;
	private RegularDie die2;
	private SpeedDie speedDie;
	
	public Cup() {
		die1 = new RegularDie();
		die2 = new RegularDie();
		speedDie = new SpeedDie();
	}
	
	public void rollDices() {
		die1.roll();
		die2.roll();
		speedDie.roll();
	}
	
	public boolean isDouble() {
		// TODO: implement this logic
		return false;
	}
}
