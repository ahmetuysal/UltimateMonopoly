package domain.bot;

import java.util.Random;

import domain.GameController;

public class RandomBotStrategy implements IBotStrategy {

	private GameController controller = GameController.getInstance();
	
	@Override
	public void makeMove(String action) {
		Random random = new Random();
		

		if(random.nextBoolean()) {
			if(action.equals("buyable"))
				controller.buyProperty();
			else if(action.equals("buyHouse"))
				controller.buildHouse();
			else if(action.equals("buyHotel"))
				controller.buildHotel();
			else if(action.equals("buySkyScraper"))
				controller.buildSkyscraper();
		}else {
			System.out.println("Will not buy in this turn");
		}
		
	}

}
