package domain.card;

import domain.GameController;
import domain.Player;

public class AdvanceToThePayCorner extends ChanceCard{

	protected AdvanceToThePayCorner(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		int layer = p.getToken().getCurrentLayer();
		if(layer == 0) {
			int loc = GameController.getInstance().getBoard().getSquareIndexFromName("PAY DAY");
			p.getToken().setLocation(loc);
			p.increaseMoney(400);
		}else if(layer == 1) {
			int loc = GameController.getInstance().getBoard().getSquareIndexFromName("GO");
			p.getToken().setLocation(loc);
			p.increaseMoney(200);
		}else if(layer == 2) {
			int loc = GameController.getInstance().getBoard().getSquareIndexFromName("BONUS");
			p.getToken().setLocation(loc);
			p.increaseMoney(300);
		}
	}

}
