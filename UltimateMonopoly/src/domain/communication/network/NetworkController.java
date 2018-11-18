package domain.communication.network;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class NetworkController {

	static Connection connection = null; 
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private GameState currentGameState;

	public NetworkController(){
		connectToGameServer();
		periodicallyUpdateGameState();
	}
	
	private static void connectToGameServer() {
		connection = new Connection(Connection.DEFAULT_SERVER_ADDRESS, Connection.DEFAULT_SERVER_PORT);
		connection.Connect();
	}

	/**
	 * updates game state periodically
	 */
	public static void periodicallyUpdateGameState() {

		final Runnable updatePeriodically = new Runnable() {
			public void run() {
				ClientHost ch = ClientHost.getInstance();
				connection.updateGameState(ch.getPlayerGameState());
				System.out.println("Client received:");
				System.out.println(ch.getPlayerGameState());

			}
		};

		final ScheduledFuture<?> checkHandle = scheduler.scheduleAtFixedRate(updatePeriodically, 1, 4, SECONDS);

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
