package domain.bot;

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

		isMyTurn = false;

		if (rand <= 0.33) {
			moveStrategy = new RandomBotStrategy();
		} else if (rand >= 0.67) {
			moveStrategy = new StingyBotStrategy();
		} else {
			moveStrategy = new GreedyBotStrategy();
		}

		controller.addPropertyListener("buyable", this);
		controller.addPropertyListener("buyHouse", this);
		controller.addPropertyListener("buyHotel", this);
		controller.addPropertyListener("buySkyScraper", this);
		controller.addPropertyListener("controller.currentPlayer", this);
		controller.addPropertyListener("pass", this);
		controller.addPropertyListener("changeRoll", this);
		controller.addPropertyListener("mrMonopoly", this);
		// controller.addPropertyListener("cardNameRollThree", this);
		// controller.addPropertyListener("cardNameChance", this);
		// controller.addPropertyListener("cardNameCommunityChest", this);
		controller.addPropertyListener("drawChanceCard", this);
		controller.addPropertyListener("drawCommunityChestCard", this);
		controller.addPropertyListener("drawRollThreeCard", this);
		controller.addPropertyListener("tripleCase", this);
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
				System.out.println("Hello after " + (System.currentTimeMillis() - i) + " ms later with " + action);
			}
		}, 500);
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
		else if(action.equals("tripleCase")) {
			controller.handleTripleForBot();
			controller.passTurn();
		}else if (action.equals("drawChanceCard"))
			controller.drawChanceCard();
		else if (action.equals("drawCommunityChestCard"))
			controller.drawCommunityChestCard();
		else if (action.equals("drawRollThreeCard"))
			controller.drawRollThreeCard();
		else if (action.equals("drawNotChanceCard")) {
			controller.playCard();
			controller.passTurn();
		} else if (action.equals("drawNotCommunityChestCard")) {
			controller.playCard();
			controller.passTurn();
		} else if (action.equals("drawNotRollThreeCard")) {
			controller.keepCard();
			controller.passTurn();
		}

	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		System.out.println(e.getPropertyName());
		if (e.getPropertyName().equals("controller.currentPlayer")) {
			if (((domain.Player) e.getNewValue()).getNickName().equals(this.getNickName())) {
				this.setMyTurn(true);
				System.out.println("Passed to bot player");
				this.playTurn("changeRoll");
			} else {
				this.setMyTurn(false);
			}
		} else if (isMyTurn) {
			if (e.getPropertyName().contains("draw")) {
				if (!(boolean) e.getNewValue()) {
					this.playTurn(e.getPropertyName().replaceAll("draw", "drawNot"));
				} else {
					this.playTurn(e.getPropertyName());
				}
			} else if (e.getPropertyName().equals("mrMonopoly")) {
				this.moveStrategy.makeMove("buyable");
				this.playTurn("pass");

			} else if (e.getPropertyName().contains("buy")) {
				if ((boolean) e.getNewValue()) {
					System.out.println("gonna buy it");
					this.playTurn(e.getPropertyName());
//					moveStrategy.makeMove(e.getPropertyName());
				}
			} else {
				if ((boolean) e.getNewValue()) {
					System.out.println("Bot is making a move");
					this.playTurn(e.getPropertyName());
				}
			}
		}
	}
}
