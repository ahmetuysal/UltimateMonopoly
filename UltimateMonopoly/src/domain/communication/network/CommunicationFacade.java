package domain.communication.network;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import domain.GameController;
import domain.die.DieValue;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class CommunicationFacade implements PropertyListener{

	private static GameController gameController;
	
	static Connection connectionForSync = null; 
	static Connection connectionForUpdate = null; 
    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	public CommunicationFacade() {
		gameController = GameController.getInstance();
		gameController.addPropertyListener(this);
		connectToGameServerForSync();
		periodicallyUpdateGameState();
		connectToGameServerForUpdate();
	}
	
	private static void connectToGameServerForSync() {

		connectionForSync = new Connection(Connection.DEFAULT_SERVER_ADDRESS, Connection.DEFAULT_SERVER_PORT);
		connectionForSync.Connect();

	}

	private static void connectToGameServerForUpdate() {

		connectionForUpdate = new Connection(Connection.DEFAULT_SERVER_ADDRESS, Connection.DEFAULT_SERVER_PORT);
		connectionForUpdate.Connect();

	}

	/**
	 * updates game state periodically
	 */
	public static void periodicallyUpdateGameState() {

		final Runnable updatePeriodically = new Runnable() {
			public void run() {
				NetworkController.getInstance().getPlayerGameState().setType("sync");
				connectionForSync.updateGameState(NetworkController.getInstance().getPlayerGameState());
				gameController.setCup(NetworkController.getInstance().getPlayerGameState().getCup());
				System.out.println("----------->>-----------");
				System.out.println("Client received:");
				System.out.println(NetworkController.getInstance().getPlayerGameState());
				System.out.println("-----------<<----------");
			}
		};

		final ScheduledFuture<?> checkHandle = scheduler.scheduleAtFixedRate(updatePeriodically, 15, 2, SECONDS);

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

	@Override
	public void onPropertyEvent(PropertyEvent e) {
	
		NetworkController.getInstance().getPlayerGameState().setCup(gameController.getCup());
		NetworkController.getInstance().getPlayerGameState().setType("update");
        connectionForUpdate.updateGameState(NetworkController.getInstance().getPlayerGameState());
		
	}
	
	
}
