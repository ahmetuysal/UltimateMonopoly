package domain.card;

import domain.GameController;
import domain.Player;
import domain.square.Location;

public class AdvanceToSaintCharlesPlace extends ChanceCard {

	protected AdvanceToSaintCharlesPlace(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String squareName) {
		// TODO Auto-generated method stub
		Location loc = GameController.getInstance().getBoard().getSquareLocationFromName("St.Charles Place");
		player.getToken().setLocation(loc);
	}

}
