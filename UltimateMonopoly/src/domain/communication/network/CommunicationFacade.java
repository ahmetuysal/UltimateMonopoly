package domain.communication.network;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import domain.GameController;
import domain.die.Cup;
import domain.die.DieValue;
import domain.gamestate.GameState;
import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class CommunicationFacade implements PropertyListener{

	private static GameController gameController;
	
	static Connection connectionForSync = null; 
	
	public CommunicationFacade() {
		gameController = GameController.getInstance();
		gameController.addPropertyListener("updateNetwork", this);
		connectToGameServerForSync();
		//sendYourStateToOtherConnecteds();
		listenToTheServer();
	}
	
	private void sendYourStateToOtherConnecteds() {
		// TODO Auto-generated method stub
		NetworkController.getInstance().getPlayerGameState().setPlayers(gameController.getPlayers());
		connectionForSync.sendChangesToTheServer(NetworkController.getInstance().getPlayerGameState());
	}

	private void listenToTheServer() {
		Thread t1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	connectionForSync.listenForAChangeOnServer();
		    }
		});  
		t1.start();
	}

	private static void connectToGameServerForSync() {

		connectionForSync = new Connection(Connection.DEFAULT_SERVER_ADDRESS, Connection.DEFAULT_SERVER_PORT);
		connectionForSync.Connect();

	}

	public void onPropertyEvent(PropertyEvent e) {
	
		if(e.getPropertyName().equals("updateNetwork")) {
			//NetworkController.getInstance().setPlayerGameState(gameController.toGameState());
			System.out.println();
			//NetworkController.getInstance().getPlayerGameState().setCup(new Cup());
			//NetworkController.getInstance().getPlayerGameState().setDie3Value(DieValue.FIVE);
	        connectionForSync.sendChangesToTheServer(GameController.getInstance().toGameState());
		}
		
		
		
	}
	
	
}
