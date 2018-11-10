package domain.card;

import domain.Player;
import domain.square.Location;

public class ChangingLanesAbove extends ChanceCard {

	public ChangingLanesAbove(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		Location loc = player.getToken().getLocation();
		if(!(loc.getLayer()==2)) {
			loc.setIndex(loc.getIndex()-2);
			player.getToken().setLocation(loc);
		}
	}

}
