package domain.card;

import domain.Board;
import domain.GameController;
import domain.Player;
import domain.square.Location;

public class AdvanceToThePayCorner extends ChanceCard {

	protected AdvanceToThePayCorner(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		Location location = p.getToken().getLocation();
		Board board = GameController.getInstance().getBoard();
		int layer = location.getLayer();
		if(layer == 0) {
			p.getToken().setLocation(board.getSquareLocationFromName("Payday"));
			p.increaseMoney(400);
		}else if(layer == 1) {
			p.getToken().setLocation(board.getSquareLocationFromName("Go"));
			p.increaseMoney(200);
		}else if(layer == 2) {
			p.getToken().setLocation(board.getSquareLocationFromName("Bonus"));
			p.increaseMoney(300);
		}
	}

}
