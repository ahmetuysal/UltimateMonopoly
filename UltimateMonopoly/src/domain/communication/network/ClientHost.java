package domain.communication.network;

public class ClientHost {
	
	private static ClientHost uniqueInstance;

	private GameState playerGameState;
	
	private ClientHost() {
		playerGameState = new GameState();
		playerGameState.setClientIndex(0);
		playerGameState.setCurrentPlayerIndex(1);
		
	}
	
	public static synchronized ClientHost getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new ClientHost();
		}
		return uniqueInstance;
	}

	public GameState getPlayerGameState() {
		return playerGameState;
	}
	
	public void setPlayerGameState(GameState newGameState) {
		if(newGameState.getClientIndex()!= playerGameState.getClientIndex()) {
			//playerGameState.setContent(newGameState.getContent()+"aa");
			playerGameState.setCurrentPlayerIndex(newGameState.getCurrentPlayerIndex());
			playerGameState.setConsecutiveDoubles(newGameState.getConsecutiveDoubles());
			playerGameState.setCurrentPlayer(newGameState.getCurrentPlayer());
			playerGameState.setCup(newGameState.getCup());
			playerGameState.setPlayers(newGameState.getPlayers());
			System.out.println("Client has changed its playerGameState");
		}
		
	}

}

