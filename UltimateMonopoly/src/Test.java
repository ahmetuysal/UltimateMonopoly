import domain.GameController;
import domain.communication.network.CommunicationFacade;
import domain.util.GameStateJSONConverter;
import ui.MonopolyFrame;
	
public class Test {

	public static void main(String[] args) {
		
		GameController controller = GameController.getInstance();
		//CommunicationFacade facade = new CommunicationFacade();
		MonopolyFrame frame = new MonopolyFrame(controller);

		
//		GameStateJSONConverter jsonConverter = GameStateJSONConverter.getInstance();
//		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme01");
//		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme02");
//		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme03");
//		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme04");
//		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme05");
//		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme06");
//		System.out.println(jsonConverter.readGameStateFromJson("deneme"));
//		System.out.println(jsonConverter.getSavedStateNames());
	}

}
