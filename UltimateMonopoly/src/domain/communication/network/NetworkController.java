package domain.communication.network;

import domain.GameController;
import domain.die.Cup;
import domain.gamestate.GameState;

public class NetworkController {

	private static NetworkController uniqueInstance;

	private GameState playerGameState;

	private NetworkController() {
		playerGameState = new GameState();
		playerGameState.setCup(new Cup());

	}

	public static synchronized NetworkController getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new NetworkController();
		}
		return uniqueInstance;
	}

	public GameState getPlayerGameState() {
		return playerGameState;
	}

	public void setPlayerGameState(GameState newGameState) {

		if(newGameState != null && newGameState.getCup()!=null) {
			System.out.println("SADECE CUP! eskisi"+GameController.getInstance().getCup());
			playerGameState.setCup(newGameState.getCup());
			GameController.getInstance().setCup(playerGameState.getCup());
			System.out.println("SADECE CUP! yenisi"+GameController.getInstance().getCup());
			
		}
		if(newGameState != null && newGameState.getPlayers() !=null 
				&& newGameState.getPlayers().size() != 0) {// && !newGameState.getLocalIp().equals(GameController.getInstance().getLocalIp())) {

			System.out.println("Client has changed its playerGameState");
			playerGameState = newGameState;
			GameController.getInstance().refreshWithGameState(newGameState);
		}
		
			

	}

}

