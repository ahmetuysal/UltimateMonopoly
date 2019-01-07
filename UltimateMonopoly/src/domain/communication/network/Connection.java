package domain.communication.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import domain.gamestate.GameState;

public class Connection {

	public static final String DEFAULT_SERVER_ADDRESS = "172.20.120.175";
	public static final int DEFAULT_SERVER_PORT = 4477;

	private Socket socket;
	protected String serverAddress;
	protected int serverPort;
	protected ObjectInputStream is;
	protected ObjectOutputStream os;

	/**
	 * Constructor
	 * 
	 * @param address
	 *            IP address of the server
	 * @param port
	 *            port number of the server
	 */
	public Connection(String address, int port) {
		serverAddress = address;
		serverPort = port;
	}

	/**
	 * Establishes a socket connection to the server that is identified by the
	 * serverAddress and the serverPort
	 */
	public void Connect() {
		try {
			socket = new Socket(serverAddress, serverPort);

			os = new ObjectOutputStream(socket.getOutputStream());
			is = null;
			try {
				is = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out
					.println("Successfully connected to " + serverAddress + " on command and data port " + serverPort);
		} catch (IOException e) {
			System.err.println("Error: no server has been found on " + serverAddress + "/" + serverPort);
		}
	}

	public void listenForAChangeOnServer() {
/////
		
			while(true) {
				GameState incomingGameState = null;
				try {
					

					Object object = null;
					try {
						object = is.readObject();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					incomingGameState = ((GameState) object);
					
					System.out.println("---RECEIVE-START-------->>-----------");
					System.out.println("Client received:");
					System.out.println(incomingGameState);
					System.out.println("----RECEIVE-OVER-------<<----------");


				} catch (IOException e) {
					e.printStackTrace();
				}
				setPlayerGameState(incomingGameState);
			}
		 
	}

	public void sendChangesToTheServer(GameState outgoingGameState) {
		try {

			System.out.println("---SEND-START-------->>-----------");
			System.out.println("Client is sending:");
			System.out.println(outgoingGameState);

			os.writeObject(outgoingGameState);
			os.flush();
			os.reset();

			System.out.println("----SEND-OVER-------<<----------");

		} catch (IOException e) {
			e.printStackTrace();

			try {
				Thread.sleep(20000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		GameState incomingGameState = null;

	}

	/**
	 * Update the game state
	 * 
	 * @param outgoingGameState
	 *            the outgoing game state
	 * @return new incoming game state
	 */

	public void updateGameState(GameState outgoingGameState) {
		GameState incomingGameState = null;
		try {

			os.writeObject(outgoingGameState);
			os.flush();
			os.reset();

			Object object = null;
			try {
				object = is.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			incomingGameState = ((GameState) object);

		} catch (IOException e) {
			e.printStackTrace();
		}

		setPlayerGameState(incomingGameState);

	}

	// when e change comes from the server, this method is triggered.
	public static void setPlayerGameState(GameState newGameState) {
		NetworkController.getInstance().setPlayerGameState(newGameState);
	}

	/**
	 * Disconnects the socket and closes the buffers
	 */
	public void Disconnect() {
		try {
			is.close();
			os.close();
			socket.close();

			System.out.println("Connection Closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
