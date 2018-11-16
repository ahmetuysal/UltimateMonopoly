package domain.square;

import domain.Player;

public class TransitStation extends Square implements Passable {

	public TransitStation() {
		super("Transit Station", "dsp");
	}
	
	@Override
	public void landOn(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passBy(Player player) {
		// Increase player's layer if even roll
		
	}

}
