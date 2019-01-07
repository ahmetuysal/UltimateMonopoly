package domain.bot;

import domain.GameController;

public class GreedyBotStrategy implements IBotStrategy {
	private GameController  controller = GameController.getInstance();
	@Override
	public void makeMove(String action) {
		if(action.equals("buyable")) {
			controller.buyProperty();
			System.out.println("tried to buy property");
		}else if(action.equals("buyHouse")) {
			controller.buildHouse();
			System.out.println("tried to buy house");
		}else if(action.equals("buyHotel")) {
			controller.buildHotel();
			System.out.println("tried to buy hotel");
		}else if(action.equals("buySkyScraper")) {
			controller.buildSkyscraper();
			System.out.println("tried to buy skyscraper");
		}
	}
}
