package domain.square;

import domain.Player;

public class TransitStation extends Square implements Passable {

	public TransitStation() {
		super("Transit Station", "dsp");
	}
	
	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic		
	}

	@Override
	public void passBy(Player player) {
		// Increase player's layer if even roll
		
	}

}
