package domain.square;

import domain.GameController;
import domain.Player;
import domain.die.DieValue;

public class TaxRefund extends Square {

	public TaxRefund() {
		super("Tax Refund", "dsc");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
		GameController g = GameController.getInstance();
		DieValue[] dieValues = g.getCup().getFaceValues();
		int sumRollValue = dieValues[0].getValue() + dieValues[1].getValue();
		if(sumRollValue % 2 == 1) {
			player.increaseMoney(g.getPoolMoney()/2);
			g.decreasePoolMoney(g.getPoolMoney()/2);
		}
	}

}
