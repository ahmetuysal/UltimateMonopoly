package domain.card;

import domain.Board;
import domain.GameController;
import domain.Player;
import domain.square.Location;

public class AdvanceToThePayCorner extends ChanceCard {

	protected AdvanceToThePayCorner(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		Location location = player.getToken().getLocation();
		Board board = GameController.getInstance().getBoard();
		int layer = location.getLayer();
		if(layer == 2) {
			player.getToken().setLocation(board.getSquareLocationFromName("Pay Day"));
			player.increaseMoney(400);
		}else if(layer == 1) {
			player.getToken().setLocation(board.getSquareLocationFromName("Go"));
			player.increaseMoney(200);
		}else if(layer == 0) {
			player.getToken().setLocation(board.getSquareLocationFromName("Bonus"));
			player.increaseMoney(300);
		}
	}

}
