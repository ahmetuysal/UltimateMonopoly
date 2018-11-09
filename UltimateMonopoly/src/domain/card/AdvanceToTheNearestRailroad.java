package domain.card;

import domain.Board;
import domain.GameController;
import domain.Player;
import domain.square.Location;
import domain.square.Square;
import domain.square.UtilitySquare;
import domain.square.UtilitySquareType;

public class AdvanceToTheNearestRailroad extends ChanceCard {

	protected AdvanceToTheNearestRailroad(String n, String d) {
		super(n, d);
	}

	@Override
	public void useCard(Player p, String s) {
		Location playerLocation = p.getToken().getLocation();
		int layerSize = Board.getLayerSize(playerLocation.getLayer());
		Board board = GameController.getInstance().getBoard();
		if (p.isReverseDirection()) {
			for (int i = 0; i < layerSize; i++) {
				// layerSize is added to avoid getting negative result from remainder
				Location location = new Location(playerLocation.getLayer(), (playerLocation.getIndex() - i + layerSize) % layerSize);
				Square sq = board.getSquare(location);
				 if(sq instanceof UtilitySquare) {
					 if (((UtilitySquare)sq).getType() == UtilitySquareType.RAILROAD) {
						 p.getToken().setLocation(location);
					 }
				 }
			}
		} else {
			for (int i = 0; i < layerSize; i++) {
				Location location = new Location(playerLocation.getLayer(), (playerLocation.getIndex() + i) % layerSize);
				Square sq = board.getSquare(location);
				 if(sq instanceof UtilitySquare) {
					 if (((UtilitySquare)sq).getType() == UtilitySquareType.RAILROAD) {
						 p.getToken().setLocation(location);
					 }
				 }
			}
		}
	}

}
