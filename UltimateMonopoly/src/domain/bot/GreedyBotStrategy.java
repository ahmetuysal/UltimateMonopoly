package domain.bot;

import domain.GameController;

public class GreedyBotStrategy implements IBotStrategy {
	private GameController  controller = GameController.getInstance();
	@Override
	public void makeMove(String action) {
		if(action.equals("buyable"))
			controller.buyProperty();
		else if(action.equals("buyHouse"))
			controller.buildHouse();
		else if(action.equals("buyHotel"))
			controller.buildHotel();
		else if(action.equals("buySkyScraper"))
			controller.buildSkyscraper();
	}

}
