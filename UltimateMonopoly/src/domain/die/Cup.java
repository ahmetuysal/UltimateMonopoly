package domain.die;

import java.util.ArrayList;

public class Cup {
	
	private RegularDie die1;
	private RegularDie die2;
	private SpeedDie speedDie;
	private ArrayList<DieValue> faceValues;
	
	public Cup() {
		die1 = new RegularDie();
		die2 = new RegularDie();
		speedDie = new SpeedDie();
	}
	
	public void rollDices() {
		die1.roll();
		die2.roll();
		speedDie.roll();
		
		faceValues.add(die1.getFaceValue());
		faceValues.add(die2.getFaceValue());
		faceValues.add(speedDie.getFaceValue());
	}
	
	public boolean isDouble() {
		return false;
	}
	
	public void setFaceValues(ArrayList<DieValue> faceValues){
		this.faceValues = faceValues;
	}
	
	public ArrayList<DieValue> getFaceResults(){
		return this.faceValues;
	}
	
	public void clearCup(){
		faceValues.clear();
	}
	
	
}
