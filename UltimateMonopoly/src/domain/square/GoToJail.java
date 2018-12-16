package domain.square;

import domain.Player;

public class GoToJail extends Square{

	public GoToJail() {
		super("Go To Jail", "dcp");
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
	}

}
