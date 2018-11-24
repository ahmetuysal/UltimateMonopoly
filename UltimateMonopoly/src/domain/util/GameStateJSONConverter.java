package domain.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.communication.network.GameState; 

public class GameStateJSONConverter {

	private static GameStateJSONConverter instance;
	
	private static final String DIRECTORY = "./GameStates/";
	
	public static synchronized GameStateJSONConverter getInstance() {
		if (instance == null)
			instance = new GameStateJSONConverter();
		return instance;
	}
	
	private GameStateJSONConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public void writeGameStateToJsonFile(GameState state, String fileName) {
		String path = DIRECTORY + fileName + ".json";
		if(System.getProperty("os.name").contains("Windows")){
			path = path.replaceAll("\\/", "\\\\");
		}
		
		try (FileWriter writer = new FileWriter(path)) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(state, writer);
		    
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}        
	}
		
	public GameState readGameStateFromJson(String fileName) {
		String path = DIRECTORY + fileName + ".json";
		if(System.getProperty("os.name").contains("Windows")){
			path = path.replaceAll("\\/", "\\\\");
		}
		
		try (FileReader reader = new FileReader(path)) {
		    Gson gson = new GsonBuilder().create();
		    return gson.fromJson(reader, GameState.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getSavedStateNames(){
		String path = DIRECTORY;
		if(System.getProperty("os.name").contains("Windows")){
			path = path.replaceAll("\\/", "\\\\");
		}
		
		File folder = new File(path);
		File[] files = folder.listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		
		List<String> gameStateNames = new ArrayList<>();
		
		for (File file : files) {
		    if (file.isFile()) {
		    	String fileName = file.getName();
		    	fileName = fileName.substring(0, fileName.lastIndexOf('.'));
		    	fileName = String.format("%1$-40s", fileName) + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(file.lastModified());
		    	gameStateNames.add(fileName);
		    }
		}
		
		return gameStateNames;
	}

}
