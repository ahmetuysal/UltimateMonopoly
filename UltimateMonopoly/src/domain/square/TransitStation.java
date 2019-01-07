package domain.square;

import domain.GameController;
import domain.Player;

public class TransitStation extends Square implements Passable {

	public TransitStation() {
		super("Transit Station", "dsp");
	}

	@Override
	public void landOn(Player player) {
		super.landOn(player);
		// TODO implement square specific logic
	}

	@Override
	public void passBy(Player player) {
		// Increase player's layer if even roll
		// (1,5)->(2,7)
		// (1,25)->(2,35)
		// (0,9)->(1,15)
		// (0,21)->(1,35)
		System.out.println("sadasd");
		System.out.println(GameController.getInstance().getCup().isEven());
		System.out.println(player.getToken().getLocation());
		if (GameController.getInstance().getCup().isEven()) {
			Location oldLoc = player.getToken().getLocation();
		//	int newLayer = oldLoc.getLayer() + 1;
			if (oldLoc.getIndex() == 5) {
				player.getToken().setLocation(new Location(2,7));
			} else if (oldLoc.getIndex() == 25) {
				player.getToken().setLocation(new Location(2,35));
			} else if (oldLoc.getIndex() == 9) {
				player.getToken().setLocation(new Location(1, 15));
			} else if (oldLoc.getIndex() == 21) {
				player.getToken().setLocation(new Location(1, 35));
			} else if(oldLoc.getIndex()==7){
				player.getToken().setLocation(new Location(1, 5));
			} else if (oldLoc.getIndex() == 35) {
				
			if(oldLoc.getLayer()==2) {
				player.getToken().setLocation(new Location(1,25));
			}else {
				player.getToken().setLocation(new Location(0,21));
			}
			} else if (oldLoc.getIndex() == 15) {
			player.getToken().setLocation(new Location(0,9));
			}else {
				return;
			}
		}
}
}
