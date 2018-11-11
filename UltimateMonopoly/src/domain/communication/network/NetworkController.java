package domain.communication.network;

import java.io.File;

public class NetworkController {

	private GameState currentGameState;
	
	public NetworkController(){
		currentGameState = new GameState();
	}
	
	public void sendGameState(File gameStateFile) {
		
	}
	
	public void receiveGameState(GameState gameState) {
		
	}
	
	public GameState parseFileToGameState(File file) {
		GameState gameState = new GameState();
		return gameState;
	}
	
	public File parseGameStateToFile(GameState gameState) {
		File file = new File("path"); //path will be added
		return file;
	}
	
	public boolean isConnected() {
		return true; //arbitrary
	}
}
