package domain.bot;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

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

		// if(rand <= 0.33) {
		// moveStrategy = new RandomBotStrategy();
		// }else if(rand >= 0.67) {
		// moveStrategy = new StingyBotStrategy();
		// }else {
		moveStrategy = new GreedyBotStrategy();
		// }

		isMyTurn = false;

		controller.addPropertyListener("buyable", this);
		controller.addPropertyListener("buyHouse", this);
		controller.addPropertyListener("buyHotel", this);
		controller.addPropertyListener("buySkyScraper", this);
		controller.addPropertyListener("controller.currentPlayer", this);
		controller.addPropertyListener("pass", this);
		controller.addPropertyListener("changeRoll", this);
		controller.addPropertyListener("cardNameRollThree", this);
		controller.addPropertyListener("cardNameChance", this);
		controller.addPropertyListener("cardNameCommunityChest", this);
		//controller.addPropertyListener("drawChanceCard",this);
		//controller.addPropertyListener("drawCommunityChestCard",this);
	}

	public void setMoveStrategy(IBotStrategy strategy) {
		moveStrategy = strategy;
	}

	public IBotStrategy getMoveStrategy() {
		return moveStrategy;
	}

	public void playTurn(String action) {
		long i = System.currentTimeMillis();
		System.out.println("Hello");
		new Timer().schedule(new TimerTask() {
			public void run() {
				BotPlayer.this.makeCommonAction(action);
				moveStrategy.makeMove(action);
				System.out.println("Hello after " + (System.currentTimeMillis() - i) + " ms later.");
			}
		}, 2000);

	}

	public boolean isMyTurn() {
		return isMyTurn;
	}

	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	public void makeCommonAction(String action) {
		if (action.equals("changeRoll"))
			controller.playTurn();
		else if (action.equals("pass"))
			controller.passTurn();
		else if(action.contains("cardNameTrue"))
			controller.playCard();
		//else if(action.contains("cardName"))
			//if(action.equals("cardName"))
			
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("controller.currentPlayer")) {
			if (((domain.Player) e.getNewValue()).getNickName().equals(this.getNickName())) {
				this.setMyTurn(true);
				System.out.println("Passed to bot player");
				this.playTurn("changeRoll");
			} else
				this.setMyTurn(false);
		} else if (isMyTurn && (boolean) e.getNewValue()) {
			System.out.println("Bot is making a move");
			if(e.getPropertyName().contains("cardName")) {
				if((boolean) e.getOldValue())
					e.getPropertyName().replaceAll("cardName", "cardNameTrue");
			}
			this.playTurn(e.getPropertyName());
		}
	}
}
