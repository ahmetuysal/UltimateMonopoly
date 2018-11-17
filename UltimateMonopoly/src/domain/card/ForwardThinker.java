package domain.card;

import domain.GameController;
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
		int layerSize = GameController.getInstance().getBoard().getLayerSize(playerLocation.getLayer());
		player.getToken().setLocation(new Location(playerLocation.getLayer(), (playerLocation.getIndex()+3)%layerSize));
	}

}
