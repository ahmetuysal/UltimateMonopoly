package domain.square;

import domain.Player;

public class ReverseDirection extends Square {

	public ReverseDirection() {
		super("Reverse Direction", "dsc");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
		player.setReverseDirection(true);
	}

}
