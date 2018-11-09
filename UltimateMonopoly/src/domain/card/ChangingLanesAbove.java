package domain.card;

import domain.Player;
import domain.square.Location;

public class ChangingLanesAbove extends ChanceCard {

	public ChangingLanesAbove(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		Location loc = p.getToken().getLocation();
		if(!(loc.getLayer()==2)) {
			loc.setIndex(loc.getIndex()-2);
			p.getToken().setLocation(loc);
		}
	}

}
