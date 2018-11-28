package domain.card;

import domain.GameController;
import domain.Player;

public class RideTheSubway extends Card {

	protected RideTheSubway(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String squareName) {
		// TODO Auto-generated method stub
		player.getToken().setLocation(GameController.getInstance().getBoard().getSquareLocationFromName("Subway"));
	}

}
