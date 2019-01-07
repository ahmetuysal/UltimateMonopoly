package domain.bot;

import domain.GameController;

public class StingyBotStrategy implements IBotStrategy {

	@Override
	public void makeMove(String action) {
		if(action.contains("buy"))
			System.out.println("cannot spend money");	
		
	}

}
