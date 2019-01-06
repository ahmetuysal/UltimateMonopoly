package domain.communication.network;

import domain.GameController;
import domain.die.Cup;
import domain.gamestate.GameState;

public class NetworkController {

	private static NetworkController uniqueInstance;

	private GameState playerGameState;

	private NetworkController() {
		playerGameState = new GameState();
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
			GameController.getInstance().setCup(playerGameState.getCup());
			// GameController.getInstance().refreshWithGameState(newGameState);
			
		}
		System.out.println("currentPlayer:"+ GameController.getInstance().getCurrentPlayerIndex());
			//TODO: other changes will be added later, currently just cup is synchronized
		
		if(newGameState != null && newGameState.getPlayers() !=null 
				&& newGameState.getPlayers().size() != 0 ) {//&& !newGameState.getLocalIp().equals(GameController.getInstance().getLocalIp())) {
			
			//playerGameState.setPlayers(newGameState.getPlayers());
			// TODO: ONEMLI !!!
			// playerGameState.getPlayer daki playerlarla gamecontroldakileri topla ve 
			// game controller dakilere esitle
			//GameController.getInstance().refreshPropertyListeners();
			//GameController.getInstance().setPlayers(playerGameState.getPlayers());
			//GameController.getInstance().publishPropertyEvent("refresh", false, true);
			playerGameState = newGameState;
			GameController.getInstance().refreshWithGameState(newGameState);
		}
		
		
		
			//playerGameState.setPlayers(newGameState.getPlayers());
			System.out.println("Client has changed its playerGameState");
			
		//}
		
		
		

	}

}

