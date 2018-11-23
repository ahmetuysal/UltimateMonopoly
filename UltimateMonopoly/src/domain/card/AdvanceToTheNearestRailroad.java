package domain.card;

import domain.Board;
import domain.GameController;
import domain.Player;
import domain.square.Location;
import domain.square.RailRoad;
import domain.square.Square;

public class AdvanceToTheNearestRailroad extends ChanceCard {

	protected AdvanceToTheNearestRailroad(String name, String description) {
		super(name, description);
	}

	@Override
	public void useCard(Player player, String s) {
		Location playerLocation = player.getToken().getLocation();
		int layerSize = Board.getLayerSize(playerLocation.getLayer());
		Board board = GameController.getInstance().getBoard();
		if (player.isReverseDirection()) {
			for (int i = 0; i < layerSize; i++) {
				// layerSize is added to avoid getting negative result from remainder
				Location location = new Location(playerLocation.getLayer(),
						(playerLocation.getIndex() - i + layerSize) % layerSize);
				Square sq = board.getSquare(location);
				if (sq instanceof RailRoad) {
					player.getToken().setLocation(location);
				}
			}
		} else {
			for (int i = 0; i < layerSize; i++) {
				Location location = new Location(playerLocation.getLayer(),
						(playerLocation.getIndex() + i) % layerSize);
				Square sq = board.getSquare(location);
				if (sq instanceof RailRoad) {
					player.getToken().setLocation(location);
				}
			}
		}
	}

}
