package domain.card;

import domain.GameController;
import domain.Player;

public class PayHospitalBills extends CommunityChestCard {

	protected PayHospitalBills(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		player.decreaseMoney(100);
		GameController.getInstance().increasePoolMoney(100);
	}

}
