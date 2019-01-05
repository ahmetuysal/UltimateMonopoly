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
		int payment = 75;
		player.decreaseMoney(payment);
		GameController.getInstance().increasePoolMoney(payment);
	}

}
