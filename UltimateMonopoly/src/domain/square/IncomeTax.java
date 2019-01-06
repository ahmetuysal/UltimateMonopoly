package domain.square;

import domain.Player;

public class IncomeTax extends Square {

	public IncomeTax() {
		super("Income Tax", "dsp");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
		player.decreaseMoney(200);
	}

}
