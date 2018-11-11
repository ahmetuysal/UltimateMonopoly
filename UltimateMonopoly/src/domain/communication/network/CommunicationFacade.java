package domain.communication.network;

import domain.GameController;

public class CommunicationFacade {

	private GameController gameController;
	private NetworkController networkController;
	
	public CommunicationFacade() {
		gameController = GameController.getInstance();
		networkController = new NetworkController();
	}
	
	public void updateGameController(GameState gameState) {
		
	}
	
	public GameState getGameState() {
		GameState gameState = new GameState();
		return gameState;
	}
	
	public void updateNetworkController(GameState gameState) {
		
	}
	
}
