package domain.card;

import domain.GameController;
import domain.Player;
import domain.square.Location;

public class GetRollin extends ChanceCard{

	protected GetRollin(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		Location location = GameController.getInstance().getBoard().getSquareLocationFromName("Roll Three");
		p.getToken().setLocation(location);
	}

}
