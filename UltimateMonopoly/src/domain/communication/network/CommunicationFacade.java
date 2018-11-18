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
		gameController.setConsecutiveDoubles(gameState.getConsecutiveDoubles());
		gameController.setCurrentPlayer(gameState.getCurrentPlayer());
		gameController.setCurrentPlayerIndex(gameState.getCurrentPlayerIndex());
		gameController.setPlayers(gameState.getPlayers());
		gameController.setCup(gameState.getCup());
	}
	
	public GameState getGameState() {
		GameState gameState = new GameState();
		gameState.setConsecutiveDoubles(gameController.getConsecutiveDoubles());
		gameState.setCup(gameController.getCup());
		gameState.setCurrentPlayer(gameController.getCurrentPlayer());
		gameState.setPlayers(gameController.getPlayerList());
		gameState.setCurrentPlayerIndex(gameController.getCurrentPlayerIndex());
		return gameState;
	}
	
	public void updateNetworkController(GameState gameState) {
		networkController.setCurrentGameState(gameState);
	}
	
	
	
}
