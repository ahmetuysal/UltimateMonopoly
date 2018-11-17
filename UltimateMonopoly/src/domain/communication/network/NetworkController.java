package domain.communication.network;

import java.io.File;

public class NetworkController {

	private GameState currentGameState;
	
	public NetworkController(){
		currentGameState = new GameState();
	}
	
	public boolean isConnected() {
		return true; //arbitrary
	}

	public GameState getCurrentGameState() {
		return currentGameState;
	}

	public void setCurrentGameState(GameState currentGameState) {
		this.currentGameState = currentGameState;
	}
	
	
}
