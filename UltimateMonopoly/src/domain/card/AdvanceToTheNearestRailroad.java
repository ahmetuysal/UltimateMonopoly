package domain.card;

import domain.GameController;
import domain.Player;

public class AdvanceToTheNearestRailroad extends ChanceCard{

	protected AdvanceToTheNearestRailroad(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player p, String s) {
		// TODO BURDA ALLAH LEVEL COUPLING VAR DUZELTIN
		int loc = p.getToken().getLocation();
		int size = GameController.getInstance().getBoard().getLayerSize(p.getToken().getCurrentLayer());
		if(!p.isReverseDirection()) {
			for(int i = loc; i<size+loc;i++) {
//				if(GameController.getInstance().getBoard().getSquare(i%size).getType() == "Railroad") {
//					p.getToken().setLocation(i);
//				}
			}
		}else {
			for(int i=loc;((i+size)%size)==loc+1 ;i--) {
//				if(GameController.getInstance().getBoard().getSquare((i+size)%size).getType() == "Railroad") {
//					p.getToken().setLocation((i+size)%size);
//				}
			}
		}
	}

}
