import domain.GameController;
import domain.communication.network.CommunicationFacade;
import domain.util.GameStateJSONConverter;
import ui.MonopolyFrame;
	
public class Test {

	public static void main(String[] args) {
		
		GameController controller = GameController.getInstance();
		//CommunicationFacade facade = new CommunicationFacade();
		MonopolyFrame frame = new MonopolyFrame(controller);

		
		GameStateJSONConverter jsonConverter = GameStateJSONConverter.getInstance();
		jsonConverter.writeGameStateToJSONFile(controller.toGameState(), "deneme01");
		jsonConverter.writeGameStateToJSONFile(controller.toGameState(), "deneme02");
		jsonConverter.writeGameStateToJSONFile(controller.toGameState(), "deneme03");
		jsonConverter.writeGameStateToJSONFile(controller.toGameState(), "deneme04");
		jsonConverter.writeGameStateToJSONFile(controller.toGameState(), "deneme05");
		jsonConverter.writeGameStateToJSONFile(controller.toGameState(), "deneme06");
		System.out.println(jsonConverter.readGameStateFromJSONFile("deneme"));
		System.out.println(jsonConverter.getSavedStateNames());
	}

}
