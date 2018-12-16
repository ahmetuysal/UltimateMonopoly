package domain.square;

import domain.Player;

public class Jail extends Square{

	public Jail() {
		super("Jail", "dsp");	
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic	}
	}
}
