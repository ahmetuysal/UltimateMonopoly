package domain.communication.network;

import domain.die.Cup;

public class NetworkController {

	private static NetworkController uniqueInstance;

	private GameState playerGameState;

	private NetworkController() {
		playerGameState = new GameState();
		playerGameState.setClientIndex(0);
		playerGameState.setCurrentPlayerIndex(1);
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

		//if(!newGameState.getContent().equals(playerGameState.getContent())) {
			//playerGameState.setContent(newGameState.getContent()+"aa");
			//playerGameState.setCurrentPlayerIndex(newGameState.getCurrentPlayerIndex());
			//playerGameState.setConsecutiveDoubles(newGameState.getConsecutiveDoubles());
			//playerGameState.setCurrentPlayer(newGameState.getCurrentPlayer());
		if(newGameState != null && newGameState.getCup()!=null) {
			playerGameState.setCup(newGameState.getCup());
		}
			//TODO: other changes will be added later, currently just cup is synchronized
		
		
		
		
			//playerGameState.setPlayers(newGameState.getPlayers());
			System.out.println("Client has changed its playerGameState");
			
		//}
		
		
		

	}

}

