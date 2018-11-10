package domain.card;

import domain.GameController;
import domain.Player;
import domain.square.Location;

public class GetRollin extends ChanceCard{

	protected GetRollin(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		Location location = GameController.getInstance().getBoard().getSquareLocationFromName("Roll Three");
		player.getToken().setLocation(location);
	}

}
