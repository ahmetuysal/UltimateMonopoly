package domain.square;

import domain.GameController;
import domain.Player;

public class LuxuryTax extends Square {

	public LuxuryTax() {
		super("Luxury Tax", "dsc");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
		player.decreaseMoney(75);
		GameController.getInstance().increasePoolMoney(75);
	}

}
