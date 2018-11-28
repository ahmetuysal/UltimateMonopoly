package domain.card;

import domain.GameController;
import domain.Player;

public class TheInsidersEdge extends Card {

	protected TheInsidersEdge(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		int layer = player.getToken().getLocation().getLayer();
		if(layer == 0)
			player.increaseMoney(250);
		else if(layer == 2) {
			player.decreaseMoney(50);
			GameController.getInstance().increasePoolMoney(50);
		}

	}

}
