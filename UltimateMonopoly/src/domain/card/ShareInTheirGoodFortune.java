package domain.card;

import domain.GameController;
import domain.Player;

public class ShareInTheirGoodFortune extends CommunityChestCard {

	protected ShareInTheirGoodFortune(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
		GameController.getInstance().getCurrentPlayer().addCard(this);
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub

	}

}
