package domain.card;

import domain.Player;
import domain.square.Location;

public class ForwardThinker extends ChanceCard {

	protected ForwardThinker(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		Location playerLocation = p.getToken().getLocation();
		p.getToken().setLocation(new Location(playerLocation.getLayer(), playerLocation.getIndex()));
	}

}
