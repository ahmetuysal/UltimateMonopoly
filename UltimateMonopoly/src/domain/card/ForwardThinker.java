package domain.card;

import domain.Player;
import domain.square.Location;

public class ForwardThinker extends ChanceCard {

	protected ForwardThinker(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		Location playerLocation = player.getToken().getLocation();
		player.getToken().setLocation(new Location(playerLocation.getLayer(), playerLocation.getIndex()));
	}

}
