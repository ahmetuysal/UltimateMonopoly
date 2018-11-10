package domain.die;

public class Cup {

	private RegularDie die1;
	private RegularDie die2;
	private RegularDie die3; // for roll triple
	private SpeedDie speedDie;
	private DieValue[] faceValues;

	public Cup() {
		die1 = new RegularDie();
		die2 = new RegularDie();
		die3 = new RegularDie();
		speedDie = new SpeedDie();
		faceValues = new DieValue[3];
	}

	public void rollTwoRegularDices() {
		die1.roll();
		die2.roll();
		speedDie.setFaceValueEmpty();
		faceValues[0] = die1.getFaceValue();
		faceValues[1] = die2.getFaceValue();
		faceValues[2] = speedDie.getFaceValue();
	}

	public void rollThreeRegularDices() {
		die1.roll();
		die2.roll();
		die3.roll();
		speedDie.setFaceValueEmpty();
		faceValues[0] = die1.getFaceValue();
		faceValues[1] = die2.getFaceValue();
		faceValues[2] = die3.getFaceValue();
	}

	public void rollDices() {
		die1.roll();
		die2.roll();
		speedDie.roll();
		faceValues[0] = die1.getFaceValue();
		faceValues[1] = die2.getFaceValue();
		faceValues[2] = speedDie.getFaceValue();
	}

	public boolean isDouble() {
		return die1.getFaceValue() == die2.getFaceValue() || die1.getFaceValue() == speedDie.getFaceValue()
				|| die2.getFaceValue() == speedDie.getFaceValue();
	}

	public boolean isTriple() {
		return die1.getFaceValue() == die2.getFaceValue() && die1.getFaceValue() == speedDie.getFaceValue();
	}

	public boolean isMrMonopoly() {
		return speedDie.getFaceValue() == DieValue.MRMONOPOLY;
	}

	public boolean isBusIcon() {
		return speedDie.getFaceValue() == DieValue.BUSICON;
	}

	public DieValue[] getFaceValues() {
		return this.faceValues;
	}

	public void clearCup() {
		for (int i = 0; i < faceValues.length; i++)
			faceValues[i] = DieValue.EMPTY;
	}
	
	public boolean isEven() {
		if(faceValues[0].equals(0) || faceValues[0].equals(2)|| faceValues[0].equals(4) || 
				faceValues[0].equals(6)||faceValues[0].equals(0)|| faceValues[0].equals(2)|| faceValues[0].equals(4) || faceValues[0].equals(6)) {
			return true;
		}else {
			return false;
		}
	}

}
