package domain.bot;

import java.util.LinkedList;

import domain.GameController;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class BotPlayer extends domain.Player implements PropertyListener {

	IBotStrategy moveStrategy;
	private boolean isMyTurn;
	private GameController controller = GameController.getInstance();
	
	public BotPlayer(String nickName) {
		super(nickName);
		
		double rand = Math.random();
		
		if(rand <= 0.33) {
			moveStrategy = new RandomBotStrategy();
		}else if(rand >= 0.67) {
			moveStrategy = new StingyBotStrategy();
		}else {
			moveStrategy = new GreedyBotStrategy();
		}
		
		isMyTurn = false;
		
		controller.addPropertyListener("buyable",this);
		controller.addPropertyListener("buyHouse",this);
		controller.addPropertyListener("buyHotel",this);
		controller.addPropertyListener("buySkyScraper",this);
		controller.addPropertyListener("controller.currentPlayer",this);
		controller.addPropertyListener("buyHouse",this);
	}

	public void setMoveStrategy(IBotStrategy strategy) {
		moveStrategy = strategy;
	}
	
	public IBotStrategy getMoveStrategy() {
		return moveStrategy;
	}
	
	public void playTurn(String action) {
		this.makeCommonAction(action);
		moveStrategy.makeMove(action);
	}
	
	
	public boolean isMyTurn() {
		return isMyTurn;
	}

	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
	
	public void makeCommonAction(String action) {
		if(action.equals("changeRoll"))
			GameController.getInstance().playTurn();
		else if(action.equals("pass"))
			GameController.getInstance().passTurn();
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if(e.getPropertyName().equals("controller.currentPlayer")) {
			if(((domain.Player) e.getNewValue()).getNickName().equals(this.getNickName()))
				this.setMyTurn(true);
			else
				this.setMyTurn(false);
		}else if(isMyTurn && (boolean) e.getNewValue()) {
			this.playTurn(e.getPropertyName());
		}		
	}
}
