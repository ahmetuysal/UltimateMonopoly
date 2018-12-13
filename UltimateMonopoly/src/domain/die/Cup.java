package domain.die;

import java.io.Serializable;

public class Cup implements Serializable{

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
		die1.roll();
		die2.roll();
		die3.roll();
		faceValues = new DieValue[3];
		faceValues[0] = die1.getFaceValue();
		faceValues[1] = die2.getFaceValue();
		faceValues[2] = die3.getFaceValue();
	}

	public void rollTwoRegularDices() {
		die1.roll();
		die2.roll();
		speedDie.setFaceValueEmpty();
		faceValues[0] = die1.getFaceValue();
		faceValues[1] = die2.getFaceValue();
		faceValues[2] = speedDie.getFaceValue();
	}
	/**
	 * 
	 * @requires regular dice and speed die are not null
	 * @modifies this, regular dice and speed die
	 * @effects sets the face value of speed die to empty and rolls 3 regular dice and fills the faceValues array with the 
	 * face values of 3 regular dice.
	 * 
	 */
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
		return die1.getFaceValue() == die2.getFaceValue();
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
	/**
	 * 
	 * @modifies this
	 * @effects sets the elements of faceValues array to empty
	 */
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
	/**
	 * 
	 * @requires two regular dice and a speedDie is rolled
	 * @modifies this, Token
	 * @effects nothing
	 * 
	 * @return the total value of the cup which determines the movement amount of the token
	 */
	public int getTotal() {
		int value = die1.getFaceValue().getValue() + die2.getFaceValue().getValue();
		if (speedDie.getFaceValue() != DieValue.BUSICON && speedDie.getFaceValue() != DieValue.MRMONOPOLY)
			value += speedDie.getFaceValue().getValue();
		return value;
	}
	
	public boolean repOK() {
		if(die1 == null)
			return false;
		if(die2 == null)
			return false;
		if(die3 == null)
			return false;
		if(speedDie == null)
			return false;
		if(faceValues == null)
			return false;
		if(die1.getFaceValue().getValue() < 1 || die1.getFaceValue().getValue() > 6)
			return false;
		if(die2.getFaceValue().getValue() < 1 || die2.getFaceValue().getValue() > 6)
			return false;
		if(die3.getFaceValue().getValue() < 1 || die3.getFaceValue().getValue() > 6)
			return false;
		if((speedDie.getFaceValue().getValue() < 0 || speedDie.getFaceValue().getValue() > 3) && speedDie.getFaceValue() != DieValue.MRMONOPOLY && speedDie.getFaceValue() != DieValue.BUSICON)
			return false;
		return true;
		
	}

}
